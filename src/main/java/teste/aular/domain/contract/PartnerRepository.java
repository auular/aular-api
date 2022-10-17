package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.aular.domain.entity.Partner;

import javax.transaction.Transactional;

public interface PartnerRepository extends JpaRepository<Partner, String> {
    boolean existsByPartnerUuid(String uuid);

}
