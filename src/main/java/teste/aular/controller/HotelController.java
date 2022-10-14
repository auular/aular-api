package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.domain.contract.HotelRepository;
import teste.aular.domain.entity.Hotel;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;



    @PostMapping
    public ResponseEntity<Hotel> postHotel(@RequestBody Hotel hotel){
        if (hotelRepository.findByHotelDocumentId(hotel.getHotelDocumentId())){
            return ResponseEntity.status(400).build();
        }
        hotelRepository.save(hotel);
        return ResponseEntity.status(200).body(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels() {
        List hotels = hotelRepository.findAll();
        return hotels.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(hotels);
    }

    @PutMapping
    public ResponseEntity<Hotel> putHotel(@PathVariable Integer id,
                                          @RequestBody Hotel hotel) {
        if (hotelRepository.existsById(id)){
            hotel.setHotelId(id);
            hotelRepository.save(hotel);
            return  ResponseEntity.status(200).body(hotel);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteHotel(@PathVariable Integer id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
