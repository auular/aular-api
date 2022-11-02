package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import teste.aular.application.PartnerCvsFileService;
import teste.aular.application.dto.UpdatePartner;
import teste.aular.domain.contract.PartnerRepository;
import teste.aular.domain.entity.Partner;
import teste.aular.utils.ListObj;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;


@RestController
@RequestMapping("/partners")
public class PartnerController {
    @Autowired
    private PartnerRepository partnerRepository;

    @PostMapping
    public ResponseEntity<Partner> addPartner(@RequestBody @Valid Partner partner) {
        partnerRepository.save(partner);
        return ResponseEntity.status(201).body(partner);
    }

    @GetMapping
    public ResponseEntity<List<Partner>> getPartner() {
        List<Partner> list = partnerRepository.findAll();
        return list.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(list);
    }

    @GetMapping("/orderedPartner")
    public ResponseEntity<?> getOrderedPartner() {
        List<Partner> list = partnerRepository.findAll();
        ListObj<Partner> orderedList = new ListObj(list.size());

        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                orderedList.add(list.get(i));
            }
            int indMenor;

            for (int i = 0; i < orderedList.getSize(); i++) {
                indMenor = i;
                for (int j = i + 1; j < orderedList.getSize(); j++) {
                    if (orderedList.getElement(j).getNumberOfCampaigns() < orderedList.getElement(indMenor).getNumberOfCampaigns()) {
                        indMenor = j;
                    }
                }
                Partner aux = orderedList.getElement(i);
                orderedList.setElement(i, orderedList.getElement(indMenor));
                orderedList.setElement(indMenor, aux);
                System.out.println(orderedList.getElement(i));
            }
            return ResponseEntity.status(200).body(orderedList);
        }
        return ResponseEntity.status(204).build();
    }


    @PatchMapping("/{id}/{email}/{fidelity}")
    public ResponseEntity<Partner> updatePartnerPartially(
            @PathVariable Integer id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Boolean fidelity,
            @RequestParam(required = false) String phoneNumber) {
        try {
            Partner partner = partnerRepository.findById(id).get();
            if (email != null) {
                partner.setEmail(email);
            }
            if (fidelity != null) {
                partner.setFidelity(fidelity);
            }
            if (phoneNumber != null) {
                partner.setPhoneNumber(phoneNumber);
            }
            return new ResponseEntity<Partner>(partnerRepository.save(partner), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<UpdatePartner> put(
//            @PathVariable int id, @RequestBody UpdatePartner updatedPartner) {
//        if (partnerRepository.existsById(id)) {
//            updatedPartner.setPartnerId(id);
//            partnerRepository.save(Partner); // faz um "update" pois o id existe
//            return ResponseEntity.status(200).body(updatedPartner);
//        }
//        return ResponseEntity.status(404).build();
//    }




    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Partner> deactivatePartner(
            @PathVariable Integer id
    ) {
        if (partnerRepository.existsById(id)) {
            Partner pa = partnerRepository.findById(id).get();
            pa.setActive(false);
            pa.setDeactivatedAt(LocalDateTime.now());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/cvsGenerator")
    public ResponseEntity<List<Partner>> getListObj() {
        ListObj<Partner> partnerListObj = new ListObj<>(partnerRepository.findAll().size());

        for (Partner p : partnerRepository.findAll()) {
            partnerListObj.add(p);
        }

        PartnerCvsFileService.PartnerCsvGenerate(partnerListObj, "partnerFile");

        return ResponseEntity.status(200).build();
    }

    @PostMapping("/autentication/{email}/{password}")
    public ResponseEntity<Partner> logIn(@PathVariable String email,
                                         @PathVariable String password) throws HttpClientErrorException {

        List<Partner> registeredPartners = partnerRepository.findAll();

        if (registeredPartners.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        for (Partner p : registeredPartners) {
            if (p.authenticatePartner(email, password)) {
                p.setAuthenticated(true);
                partnerRepository.save(p);
                return ResponseEntity.status(200).body(p);
            }
        }
        return ResponseEntity.status(401).build();
    }

    @DeleteMapping("autentication/{id}")
    public ResponseEntity<String> logOff(@PathVariable Integer id) {
        try {
            if (partnerRepository.existsById(id)) {
                Partner h = partnerRepository.findById(id).get();
                h.setAuthenticated(false);
                partnerRepository.save(h);
                return ResponseEntity.status(200).build();
            }
            return ResponseEntity.status(404).build();

        } catch (HttpClientErrorException.NotFound e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(404).build();
    }

}
