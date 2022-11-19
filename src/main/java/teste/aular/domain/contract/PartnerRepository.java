package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.aular.domain.entity.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    boolean existsByPartnerUuid(String uuid);

}
