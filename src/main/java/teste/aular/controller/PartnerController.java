package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.application.FileService;
import teste.aular.domain.contract.PartnerRepository;
import teste.aular.domain.entity.Partner;
import teste.aular.domain.entity.PetTutor;
import teste.aular.utils.ListObj;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;



@RestController
@RequestMapping("/partners")
public class PartnerController {
    @Autowired
    private PartnerRepository partnerRepository;

    @PostMapping
    public ResponseEntity<Partner> addPartner(@RequestBody Partner partner) {
        partnerRepository.save(partner);
        return  ResponseEntity.status(201).body(partner);
    }

    @GetMapping
    public ResponseEntity<List<Partner>> getPartner(){
        List<Partner> list = partnerRepository.findAll();
        return list.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(list);
    }

    @PatchMapping("/{uuid}/{email}/{fidelity}")
    public ResponseEntity<Partner> updatePartnerPartially(
            @PathVariable String uuid,
            @RequestParam(required=false) String email,
            @RequestParam(required=false) Boolean fidelity,
            @RequestParam(required=false) String phoneNumber){
        try {
            Partner partner = partnerRepository.findById(uuid).get();
            if (email != null){
                partner.setEmail(email);
            }
            if (fidelity != null){
                partner.setFidelity(fidelity);
            }
            if (phoneNumber != null){
                partner.setPhoneNumber(phoneNumber);
            }
            return new ResponseEntity<Partner>(partnerRepository.save(partner), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{uuid}")
    @Transactional
    public ResponseEntity<Partner> deactivatePartner(
            @PathVariable String uuid
    ) {
        if (partnerRepository.existsByPartnerUuid(uuid)) {
            Partner pa = partnerRepository.findById(uuid).get();
            pa.setActive(false);
            pa.setDeactivatedAt(LocalDateTime.now());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
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
