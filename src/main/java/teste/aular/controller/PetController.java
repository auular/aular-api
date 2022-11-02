package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.domain.contract.PetRepository;
import teste.aular.domain.contract.PetTutorRepository;
import teste.aular.domain.entity.Campaign;
import teste.aular.domain.entity.Pet;
import teste.aular.domain.entity.PetTutor;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetTutorRepository petTutorRepository;

    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody @Valid Pet pet) {
        petRepository.save(pet);
        return ResponseEntity.status(201).body(pet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getPet() {
        List<Pet> list = petRepository.findAll();
        return list.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(list);
    }

    @GetMapping("{petTutorId}")
    public ResponseEntity<List<Pet>> getPetsByPetTutor(@PathVariable Integer petTutorId){
        if (petTutorRepository.existsById(petTutorId)) {
            //PetTutor petTutor = petTutorRepository.findById(petTutorId).get();

            List<Pet> petsList = petRepository.findAllByPetTutorPetTutorId(petTutorId);

            return petsList.isEmpty()
                    ? ResponseEntity.status(204).build()
                    : ResponseEntity.status(200).body(petsList);
        }
        return ResponseEntity.status(204).build();
    }


}
