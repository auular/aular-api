package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.application.LeadTxtFile;
import teste.aular.domain.contract.LeadPetRepository;
import teste.aular.domain.contract.LeadPetTutorRepository;
import teste.aular.domain.entity.LeadPet;
import teste.aular.domain.entity.LeadPetTutor;

import java.util.List;


@RestController
@RequestMapping("/leads")
public class LeadController {
    @Autowired
    private LeadPetTutorRepository leadPetTutorRepository;

    @Autowired
    private LeadPetRepository leadPetRepository;

    @GetMapping
    public ResponseEntity<List<LeadPet>> getPetTutors() {
        List<LeadPet> lista = leadPetRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/txtReading")
    public ResponseEntity<?> txtReading(){
        LeadTxtFile.lerArquivoTxt("LEADS.TXT");

        LeadTxtFile lista1 = new LeadTxtFile();
        for (LeadPetTutor leadPetTutor : lista1.getListLeadPetTutorReaded()){
            leadPetTutorRepository.save(leadPetTutor);
        }

        LeadTxtFile lista2 = new LeadTxtFile();
        for (LeadPet leadPet : lista2.getListLeadPetReaded()){
            leadPetRepository.save(leadPet);
        }

        return ResponseEntity.status(200).build();
    }
}
