package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.application.FileService;
import teste.aular.domain.contract.PartnerRepository;
import teste.aular.domain.entity.Partner;
import teste.aular.domain.entity.PetTutor;
import teste.aular.utils.ListObj;
import teste.aular.application.FileService;

import java.util.List;


@RestController
@RequestMapping("/partners")
public class PartnerController {
    @Autowired
    private PartnerRepository partnerRepository;

    @GetMapping
    public List<Partner> getPartners() {
        return partnerRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Partner> addPartner(@RequestBody Partner p) {
        partnerRepository.save(p);
        return ResponseEntity.status(201).body(p);
    }

    @GetMapping("/gerarArquivo")
    public ResponseEntity<List<PetTutor>> getListObj() {
        ListObj<Partner> partnerListObj = new ListObj<>(partnerRepository.findAll().size());

        for (Partner p : partnerRepository.findAll()) {
            partnerListObj.adiciona(p);
        }

        FileService.gravaArquivoCsv(partnerListObj, "partnerFile");

        return ResponseEntity.status(200).build();
    }

}
