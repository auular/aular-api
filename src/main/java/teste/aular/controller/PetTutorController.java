package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.domain.contract.PetTutorRepository;
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

    //Método para devolver o ID através do documentId
    public Integer findId(String documentId) {
        List<PetTutor> petTutors = petTutorRepository.findAll();
        for (PetTutor petTutor : petTutors) {
            if (petTutor.getDocumentId().equals(documentId)) {
                //System.out.println("ID encontrado");
                return petTutor.getIdPetTutor();
            }
        }
        return null;
    }

    @GetMapping
    public ResponseEntity<List<PetTutor>> getPetTutors() {
        List<PetTutor> lista = petTutorRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @PostMapping
    public ResponseEntity<PetTutor> addPetTutor(@RequestBody PetTutor petTutor) {
        petTutor.setCreated_at(LocalDateTime.now());
        petTutor.setUpdated_at(LocalDateTime.now());
        petTutorRepository.save(petTutor);
        return ResponseEntity.status(201).body(petTutor);
    }

    @PutMapping("/{documentId}")
    @Transactional
    public ResponseEntity<PetTutor> updatePetTutor(
            @PathVariable String documentId,
            @RequestBody PetTutor petTutor) {
        if (petTutorRepository.existsByDocumentId(documentId)) {

            PetTutor pe = petTutorRepository.findById(findId(documentId)).get();

            petTutor.setIdPetTutor(findId(documentId));
            petTutor.setCreated_at(pe.getCreated_at());
            petTutor.setUpdated_at(LocalDateTime.now());
            petTutorRepository.save(petTutor);
            return ResponseEntity.status(200).body(petTutor);
        }
        return ResponseEntity.status(404).build();
    }

    //Métodos que seta o PetTutor como inativo
    @DeleteMapping("/{documentId}")
    @Transactional
    public ResponseEntity<PetTutor> deactivatePetTutor(
            @PathVariable String documentId
    ) {
        if (petTutorRepository.existsByDocumentId(documentId)) {
            PetTutor pe = petTutorRepository.findById(findId(documentId)).get();
            pe.setActive(false);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

//    @DeleteMapping("/{documentId}")
//    public ResponseEntity<Void> deletePetTutor(@PathVariable String documentId) {
//        if (petTutorRepository.existsByDocumentId(documentId)) {
//            //petTutorRepository.deleteByDocumentId(documentId);
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(404).build();
//    }


}
