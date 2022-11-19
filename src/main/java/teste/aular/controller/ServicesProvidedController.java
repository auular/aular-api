package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.domain.contract.HotelRepository;
import teste.aular.domain.contract.ServicesProvidedRepository;
import teste.aular.domain.entity.ServicesProvided;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/services-provided")
public class ServicesProvidedController {

    @Autowired
    private ServicesProvidedRepository servicesProvidedRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping
    public ResponseEntity<ServicesProvided> addServicesProvided(@RequestBody @Valid ServicesProvided servicesProvided) {
        servicesProvidedRepository.save(servicesProvided);
        return ResponseEntity.status(201).body(servicesProvided);
    }

    @GetMapping
    public ResponseEntity<List<ServicesProvided>> getPlan() {
        List<ServicesProvided> list = servicesProvidedRepository.findAll();
        return list.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(list);
    }
}
