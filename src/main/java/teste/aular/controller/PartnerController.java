package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.domain.contract.PartnerRepository;
import teste.aular.domain.entity.Partner;

import java.time.Instant;
import java.util.List;
import java.util.UUID;


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
}
