package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teste.aular.domain.entity.Address;
import teste.aular.response.HotelAddressResponse;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT new teste.aular.domain.entity.Address(a.addressId, a.addressCode, a.addressStreet, a.addressNumber, " +
            "a.addressComplement, a.addressDistrict, a.addressCity, a.addressState) " +
            "FROM Address a " +
            "WHERE a.hotel.hotelId = ?1 ")
    Optional<Address> getSimpleAddressByHotelId(int hotelId);

    @Query("SELECT new teste.aular.domain.entity.Address(a.addressId, a.addressCode, a.addressStreet, a.addressNumber, " +
            "a.addressComplement, a.addressDistrict, a.addressCity, a.addressState) " +
            "FROM Address a " +
            "WHERE a.hotel.hotelUuid = ?1 ")
    Optional<Address> getSimpleAddressByHotelUuid(String hotelUuid);

    @Query("SELECT new teste.aular.domain.entity.Address(a.addressId, a.addressCode, a.addressStreet, a.addressNumber, " +
            "a.addressComplement, a.addressDistrict, a.addressCity, a.addressState) " +
            "FROM Address a " +
            "WHERE a.petTutor.petTutorId = ?1 ")
    Optional<Address> getSimpleAddressByPetTutorId(int petTutorId);


    @Query("SELECT new teste.aular.response.HotelAddressResponse(" +
            "a.hotel.hotelId, a.hotel.hotelUuid, a.addressCode, a.addressStreet, a.addressNumber, " +
            "a.addressComplement, a.addressDistrict, a.addressCity, a.addressState ) " +
            "FROM Address a ")
    Optional<List<HotelAddressResponse>> getHotelsAddress();

}
