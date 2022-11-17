package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.aular.domain.entity.ServicesProvided;

public interface ServicesProvidedRepository extends JpaRepository<ServicesProvided, Integer> {
}
