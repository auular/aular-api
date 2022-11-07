package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import teste.aular.domain.entity.Hotel;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

     boolean existsByDocumentId(String hotelDocumentId);


     boolean existsByHotelUuid(String uuid);

     @Modifying
     @Query("UPDATE tab_hotel h SET h.phone_number =: phone WHERE h.hotel_id = :id")
     void updatePhone(Integer id, String phone);


}
