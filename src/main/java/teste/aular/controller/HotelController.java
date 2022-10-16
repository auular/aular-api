package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import teste.aular.domain.contract.HotelRepository;
import teste.aular.domain.entity.Hotel;
import teste.aular.domain.entity.Partner;

import javax.swing.*;
import javax.validation.Valid;
import java.net.http.HttpClient;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;

    private List<Hotel> hotels = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Hotel> postHotel(@RequestBody @Valid Hotel hotel) {
        if (hotelRepository.existsByDocumentId(hotel.getDocumentId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        hotelRepository.save(hotel);
        return ResponseEntity.status(201).body(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels() {
        List hotels = hotelRepository.findAll();
        return hotels.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(hotels);
    }

    @PutMapping
    public ResponseEntity<Hotel> putHotel(@PathVariable String uuid,
                                          @RequestBody Hotel hotel) {
        if (hotelRepository.existsById(uuid)) {
            hotel.setHotelUuid(uuid);
            hotelRepository.save(hotel);
            return ResponseEntity.status(200).body(hotel);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteHotel(@PathVariable String uuid) {
        if (hotelRepository.existsById(uuid)) {

            hotelRepository.deleteById(uuid);
            ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/autentication/{email}/{password}")
    public ResponseEntity<Hotel> logIn(@PathVariable String email,
                                        @PathVariable String password) throws HttpClientErrorException {

        List<Hotel> registeredHotels = hotelRepository.findAll();

        if (registeredHotels.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

            for (Hotel h : registeredHotels) {
                if (h.authenticateHotel(email, password)) {
                    h.setAuthenticated(true);
                    hotelRepository.save(h);
                    return ResponseEntity.status(200).body(h);
                }
            }
        return ResponseEntity.status(401).build();
    }

    @DeleteMapping("autentication/{uuid}")
    public ResponseEntity<String> logOff(@PathVariable String uuid) {
        try {
            if (hotelRepository.existsByHotelUuid(uuid)) {
                Hotel h = hotelRepository.findById(uuid).get();
                h.setAuthenticated(false);
                h.setDeactivatedAt(LocalDateTime.now());
                hotelRepository.save(h);
                return ResponseEntity.status(200).build();
            }
            return ResponseEntity.status(404).build();

        } catch (HttpClientErrorException.NotFound e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(404).build();
    }

}
