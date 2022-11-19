package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.domain.contract.AddressRepository;
import teste.aular.domain.entity.Address;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @GetMapping
    public ResponseEntity<List<Address>> getAddress() {
        List<Address> list = addressRepository.findAll();
        return list.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(list);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody @Valid Address address) {
        addressRepository.save(address);
        return ResponseEntity.status(201).body(address);
    }
}
