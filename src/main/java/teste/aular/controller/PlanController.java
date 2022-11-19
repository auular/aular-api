package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.domain.contract.PartnerRepository;
import teste.aular.domain.contract.PlanRepository;
import teste.aular.domain.entity.Plan;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @PostMapping
    public ResponseEntity<Plan> addPlan(@RequestBody @Valid Plan plan) {
        planRepository.save(plan);
        return ResponseEntity.status(201).body(plan);
    }

    @GetMapping
    public ResponseEntity<List<Plan>> getPlan() {
        List<Plan> list = planRepository.findAll();
        return list.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(list);
    }
}
