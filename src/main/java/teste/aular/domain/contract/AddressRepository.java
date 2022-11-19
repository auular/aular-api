package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teste.aular.domain.entity.Address;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT new teste.aular.domain.entity.Address(a.addressId, a.addressCode, a.addressStreet, a.addressNumber, " +
            "a.addressComplement, a.addressDistrict, a.addressCity, a.addressState) " +
            "FROM Address a " +
            "WHERE a.hotel.hotelId = ?1 ")
    Optional<Address> getSimpleAddress(int hotelId);

}
