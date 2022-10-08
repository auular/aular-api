package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.aular.domain.entity.Partner;

import java.util.UUID;

public interface PartnerRepository extends JpaRepository<Partner, UUID> {}
