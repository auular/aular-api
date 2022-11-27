package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teste.aular.domain.entity.Plan;
import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    @Query("SELECT new teste.aular.domain.entity.Plan(p.planId, p.planType, p.planValue) " +
            "FROM Plan p " +
            "WHERE p.hotel.hotelId = ?1 ")
    Optional<Plan> getSimplePlanByHotelId(int hotelId);

    @Query("SELECT new teste.aular.domain.entity.Plan(p.planId, p.planType, p.planValue) " +
            "FROM Plan p " +
            "WHERE p.hotel.hotelUuid = ?1 ")
    Optional<Plan> getSimplePlanByHotelUuid(String hotelUuid);

}
