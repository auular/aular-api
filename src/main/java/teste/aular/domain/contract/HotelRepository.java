package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import teste.aular.domain.entity.Hotel;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

//     @Modifying(clearAutomatically = true)
//     @Query("UPDATE hotel h SET h.phone_number = :phone WHERE h.hotel_id = :id")
//     int updatePhone(@Param("hotel_id") Integer id, @Param("phone_number") String phone);

     boolean existsByDocumentId(String hotelDocumentId);


     boolean existsByHotelUuid(String uuid);


     boolean existsByEmail(String email);


     boolean existsByPhoneNumber(String phoneNumber);






//
//
//     @Modifying
//     @Query("value = UPDATE tab_hotel h SET h.name = :name WHERE h.hotel_id = :id")
//     void updateName(String name, Integer id);
//
//     @Modifying
//     @Query("value = UPDATE tab_hotel h SET h.email = :email WHERE h.hotel_id = :id")
//     void updateEmail(String email, Integer id);
//
//     @Modifying
//     @Query("value = UPDATE tab_hotel h SET h.password = :password WHERE h.hotel_id = :id")
//     void updatePassword(String password, Integer id);

}
