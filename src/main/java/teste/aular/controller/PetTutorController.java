package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import teste.aular.application.LeadTxtFile;
import teste.aular.domain.contract.PetTutorRepository;
import teste.aular.domain.contract.PetRepository;
import teste.aular.domain.entity.PetTutor;
import teste.aular.response.PetTutorAllFieldsResponse;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/petTutors")
public class PetTutorController {
    @Autowired
    private PetTutorRepository petTutorRepository;

    @Autowired
    private PetRepository petRepository;

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

    @GetMapping("/txtReading")
    public ResponseEntity<?> txtReading(){
        LeadTxtFile.lerArquivoTxt("PETTUTORANDPET.TXT");

//        PetTutorAndTutorTxtFile lista1 = new PetTutorAndTutorTxtFile();
//        for (PetTutor pT : lista1.getListPetTutorReaded()){
//            petTutorRepository.save(pT);
//        }
//
//        PetTutorAndTutorTxtFile lista2 = new PetTutorAndTutorTxtFile();
//        for (Pet p : lista2.getListPetReaded()){
//            petRepository.save(p);
//        }

        return ResponseEntity.status(200).build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PetTutor> updatePetTutor(
            @PathVariable Integer id,
            @RequestBody PetTutor petTutor) {
        if (petTutorRepository.existsById(id)) {
            PetTutor pe = petTutorRepository.findById(id).get();
            petTutor.setPetTutorId(id);
            petTutorRepository.save(petTutor);
            return ResponseEntity.status(200).body(petTutor);
        }
        return ResponseEntity.status(404).build();
    }

    //Métodos que seta o PetTutor como inativo
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PetTutor> deactivatePetTutor(
            @PathVariable Integer id
    ) {
        if (petTutorRepository.existsById(id)) {
            PetTutor pe = petTutorRepository.findById(id).get();
            pe.setActive(false);
            pe.setDeactivatedAt(LocalDateTime.now());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

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

    //Método para deletar definitivamente o PetTutor
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

    @DeleteMapping("autentication/{id}")
    public ResponseEntity<String> logOff(@PathVariable Integer id) {
        try {
            if (petTutorRepository.existsById(id)) {
                PetTutor h = petTutorRepository.findById(id).get();
                h.setAuthenticated(false);
                h.setDeactivatedAt(LocalDateTime.now());
                petTutorRepository.save(h);
                return ResponseEntity.status(200).build();
            }
            return ResponseEntity.status(404).build();

        } catch (HttpClientErrorException.NotFound e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/allFields/{petTutorId}")
    public ResponseEntity<PetTutorAllFieldsResponse> getAllFields(@PathVariable int petTutorId){
        return ResponseEntity.of(petTutorRepository.getPetTutorAllFieldsResponse(petTutorId));
    }

}
