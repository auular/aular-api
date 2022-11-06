package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.aular.domain.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
