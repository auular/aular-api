package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import teste.aular.domain.contract.HotelRepository;
import teste.aular.domain.entity.Hotel;
import teste.aular.service.HotelService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> postHotel(@RequestBody @Valid Hotel hotel) throws IllegalArgumentException {

        if (hotelService.addHotel(hotel)) {
            return ResponseEntity.status(201).body(hotel);
        }
        return ResponseEntity.status(403).build();
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels() {
        List hotels = hotelService.getAllHotels();
        return hotels.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(hotels);
    }

    //
    @PatchMapping("/account/{id}/{phoneNumber}")
    public ResponseEntity<Optional<Hotel>> putHotelPhoneNumber(@PathVariable Integer id, @PathVariable String phoneNumber) {
        if (hotelService.updateHotelPhoneNumber(id, phoneNumber))
            return ResponseEntity.status(200).build();
        else {
            return ResponseEntity.status(404).build();
        }
    }
//
//    @PatchMapping
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity<Hotel> deactiveHotel(
//            @PathVariable Integer id) {
//        if (hotelRepository.existsById(id)) {
//            Hotel h = hotelRepository.findById(id).get();
//            h.setActive(false);
//            h.setDeactivatedAt(LocalDateTime.now());
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(204).build();
//    }
//
//    @PostMapping("/autentication/{email}/{password}")
//    public ResponseEntity<Hotel> logIn(@PathVariable String email,
//                                        @PathVariable String password){
//
//        List<Hotel> registeredHotels = hotelRepository.findAll();
//
//        if (registeredHotels.isEmpty()) {
//            return ResponseEntity.status(404).build();
//        }
//
//            for (Hotel h : registeredHotels) {
//                if (h.authenticateHotel(email, password)) {
//                    h.setAuthenticated(true);
//                    hotelRepository.save(h);
//                    return ResponseEntity.status(200).body(h);
//                }
//            }
//        return ResponseEntity.status(401).build();
//    }
//
//    @DeleteMapping("autentication/{id}")
//    public ResponseEntity<String> logOff(@PathVariable Integer id) {
//        try {
//            if (hotelRepository.existsById(id)) {
//                Hotel h = hotelRepository.findById(id).get();
//                h.setAuthenticated(false);
//                h.setDeactivatedAt(LocalDateTime.now());
//                hotelRepository.save(h);
//                return ResponseEntity.status(200).build();
//            }
//            return ResponseEntity.status(404).build();
//
//        } catch (HttpClientErrorException.NotFound e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.status(404).build();
//    }

}
