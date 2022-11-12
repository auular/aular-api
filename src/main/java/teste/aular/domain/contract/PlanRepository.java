package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.aular.domain.entity.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
