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
     @Query("UPDATE tab_hotel h SET h.phone_number = :phone WHERE h.hotel_id = :id")
     void updatePhone(String phone, Integer id);


     @Modifying
     @Query("value = UPDATE tab_hotel h SET h.name = :name WHERE h.hotel_id = :id")
     void updateName(String name, Integer id);

     @Modifying
     @Query("value = UPDATE tab_hotel h SET h.email = :email WHERE h.hotel_id = :id")
     void updateEmail(String email, Integer id);

     @Modifying
     @Query("value = UPDATE tab_hotel h SET h.password = :password WHERE h.hotel_id = :id")
     void updatePassword(String password, Integer id);

}
