package teste.aular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teste.aular.domain.contract.HotelRepository;
import teste.aular.domain.entity.Hotel;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public boolean addHotel(Hotel hotel) {
        if (hotel != null) {
            if (!hotelRepository.existsByDocumentId(hotel.getDocumentId())){

                if (!hotelRepository.existsByEmail(hotel.getEmail())) {
                    hotelRepository.save(hotel);
                    return true;
                }
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This email has already been registered ");
            }
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This document ID has already been registered ");
        }
        return false;
    }

    public boolean updateHotelPhoneNumber(Integer id, String phoneNumber) {
        Optional<Hotel> h = hotelRepository.findById(id);

        if (!hotelRepository.existsByPhoneNumber(phoneNumber)) {
            h.get().setPhoneNumber(phoneNumber);
            hotelRepository.save(h.get());
            return true;
        }

        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This phone number has already been registered");

    }

    public List<Hotel> getAllHotels() {
        List hotels = hotelRepository.findAll();
        if (hotels.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no hotels to show");
        return hotels;
    }
}
