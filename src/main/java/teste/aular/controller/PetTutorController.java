package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import teste.aular.domain.contract.PetTutorRepository;
import teste.aular.domain.entity.Partner;
import teste.aular.domain.entity.PetTutor;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/petTutors")
public class PetTutorController {
    @Autowired
    private PetTutorRepository petTutorRepository;

    @GetMapping
    public ResponseEntity<List<PetTutor>> getPetTutors() {
        List<PetTutor> lista = petTutorRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<PetTutor> addPetTutor(@RequestBody PetTutor petTutor) {
        petTutorRepository.save(petTutor);
        return ResponseEntity.status(201).body(petTutor);
    }

//    @PutMapping("/{uuid}")
//    @Transactional
//    public ResponseEntity<PetTutor> updatePetTutor(
//            @PathVariable String uuid,
//            @RequestBody PetTutor petTutor) {
//        if (petTutorRepository.existsByDocumentId(uuid)) {
//            PetTutor pe = petTutorRepository.findById(uuid).get();
//            petTutor.setPetTutorId(findId(uuid));
//            petTutorRepository.save(petTutor);
//            return ResponseEntity.status(200).body(petTutor);
//        }
//        return ResponseEntity.status(404).build();
//    }

    //Métodos que seta o PetTutor como inativo
//    @DeleteMapping("/{uuid}")
//    @Transactional
//    public ResponseEntity<PetTutor> deactivatePetTutor(
//            @PathVariable String uuid
//    ) {
//        if (petTutorRepository.existsById(uuid)) {
//            PetTutor pe = petTutorRepository.findById(uuid).get();
//            pe.setActive(false);
//            pe.setDeactivatedAt(LocalDateTime.now());
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(404).build();
//    }

    //Método para devolver o ID através do documentId
    public Integer findId(String documentId) {
        List<PetTutor> petTutors = petTutorRepository.findAll();
        for (PetTutor petTutor : petTutors) {
            if (petTutor.getDocumentId().equals(documentId)) {
                //System.out.println("ID encontrado");
                return petTutor.getPetTutorId();
            }
        }
        return null;
    }

//    @DeleteMapping("/{documentId}")
//    public ResponseEntity<Void> deletePetTutor(@PathVariable String documentId) {
//        if (petTutorRepository.existsByDocumentId(documentId)) {
//            //petTutorRepository.deleteByDocumentId(documentId);
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(404).build();
//    }


    @PostMapping("/autentication/{email}/{password}")
    public ResponseEntity<PetTutor> logIn(@PathVariable String email,
                                         @PathVariable String password) throws HttpClientErrorException {

        List<PetTutor> registeredPetTutors = petTutorRepository.findAll();

        if (registeredPetTutors.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        for (PetTutor p : registeredPetTutors) {
            if (p.authenticatePetTutor(email, password)) {
                p.setAuthenticated(true);
                petTutorRepository.save(p);
                return ResponseEntity.status(200).body(p);
            }
        }
        return ResponseEntity.status(401).build();
    }

//    @DeleteMapping("autentication/{uuid}")
//    public ResponseEntity<String> logOff(@PathVariable String uuid) {
//        try {
//            if (petTutorRepository.existsByPetTutorUuid(uuid)) {
//                PetTutor h = petTutorRepository.findById(uuid).get();
//                h.setAuthenticated(false);
//                h.setDeactivatedAt(LocalDateTime.now());
//                petTutorRepository.save(h);
//                return ResponseEntity.status(200).build();
//            }
//            return ResponseEntity.status(404).build();
//
//        } catch (HttpClientErrorException.NotFound e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.status(404).build();
//    }

}
