package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.aular.domain.entity.LeadPet;

public interface LeadPetRepository extends JpaRepository<LeadPet, Integer> {

}
