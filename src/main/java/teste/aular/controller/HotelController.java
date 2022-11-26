package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import teste.aular.domain.contract.*;
import teste.aular.domain.entity.*;
import teste.aular.response.HotelAddressResponse;
import teste.aular.response.HotelAllFieldsResponse;
import teste.aular.service.HotelService;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ServicesProvidedRepository servicesProvidedRepository;

    @PostMapping
    public ResponseEntity<Integer> postHotel(@RequestBody @Valid Hotel hotel) throws IllegalArgumentException {

        if (hotelService.addHotel(hotel)) {
            return ResponseEntity.status(201).body(hotel.getHotelId());
        }
        return ResponseEntity.status(403).build();
    }

    @PostMapping("/allFields/{hotelId}")
    public ResponseEntity postAllFields(@RequestBody HotelAllFieldsResponse hotelAllFieldsResponse,
                                                           @PathVariable int hotelId) throws IllegalArgumentException {

        if (!hotelRepository.existsById(hotelId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "hotelId não encontrado ao cadastrar endereço e serviços"
            );
        }
        campaignRepository.save(hotelAllFieldsResponse.getCampaign());
        planRepository.save(hotelAllFieldsResponse.getPlan());
        addressRepository.save(hotelAllFieldsResponse.getAddress());
        servicesProvidedRepository.save(hotelAllFieldsResponse.getServicesProvided());
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels() {
        List hotels = hotelService.getAllHotels();
        return hotels.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(hotels);
    }

    //
    @PatchMapping("/account/{id}/{phoneNumber}")
    public ResponseEntity<Optional<Hotel>> putHotelPhoneNumber(@PathVariable Integer id, @PathVariable String phoneNumber) {
        if (hotelService.updateHotelPhoneNumber(id, phoneNumber)) return ResponseEntity.status(200).build();

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/allFields/{hotelId}")
    public ResponseEntity<HotelAllFieldsResponse> getAllFieldsById(@PathVariable int hotelId){

        Optional<Campaign> c = campaignRepository.getSimpleCampaignByHotelId(hotelId);
        Optional<Hotel> h = hotelRepository.findById(hotelId);
        Optional<Plan> p = planRepository.getSimplePlanByHotelId(hotelId);
        Optional<Address> a = addressRepository.getSimpleAddressByHotelId(hotelId);
        Optional<ServicesProvided> s = servicesProvidedRepository.getSimpleAddressByHotelId(hotelId);

        HotelAllFieldsResponse hf = new HotelAllFieldsResponse(h.get(), c.get(), p.get(), a.get(), s.get());

        return ResponseEntity.of(Optional.of(hf));
    }

    @GetMapping("/addresses")
    public ResponseEntity<Optional<List<HotelAddressResponse>>> getHotelAddress() {
        Optional<List<HotelAddressResponse>> list = addressRepository.getHotelsAddress();
        return list.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(list);
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
