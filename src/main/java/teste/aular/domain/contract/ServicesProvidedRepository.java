package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teste.aular.domain.entity.Address;
import teste.aular.domain.entity.ServicesProvided;

import java.util.Optional;

public interface ServicesProvidedRepository extends JpaRepository<ServicesProvided, Integer> {

    @Query("SELECT new teste.aular.domain.entity.ServicesProvided(s.servicesProvidedId, s.servicePool, s.servicePlayground, " +
            "s.serviceToys, s.serviceBath, s.serviceLeathering, s.serviceBedroom, s.serviceFood, s.serviceVisitation, " +
            "s.serviceCam, s.serviceExercises, s.serviceTraining, s.serviceDentist, s.serviceVet, s.serviceMonitoring, " +
            "s.dogsAcepted, s.catsAcepted, s.othersAcepted, s.averagePrice, s.guestsNumber) " +
            "FROM ServicesProvided s " +
            "WHERE s.hotel.hotelId = ?1 ")
    Optional<ServicesProvided> getSimpleAddressByHotelId(int hotelId);

    @Query("SELECT new teste.aular.domain.entity.ServicesProvided(s.servicesProvidedId, s.servicePool, s.servicePlayground, " +
            "s.serviceToys, s.serviceBath, s.serviceLeathering, s.serviceBedroom, s.serviceFood, s.serviceVisitation, " +
            "s.serviceCam, s.serviceExercises, s.serviceTraining, s.serviceDentist, s.serviceVet, s.serviceMonitoring, " +
            "s.dogsAcepted, s.catsAcepted, s.othersAcepted, s.averagePrice, s.guestsNumber) " +
            "FROM ServicesProvided s " +
            "WHERE s.hotel.hotelUuid = ?1 ")
    Optional<ServicesProvided> getSimpleAddressByHotelUuid(String hotelUuid);

}
