package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import teste.aular.domain.entity.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    boolean existsByPartnerUuid(String uuid);

    @Modifying
    @Transactional
    @Query("update Partner p set p.relatorioCampanha = ?2 where p.id = ?1")
    void setRelatorio(Integer id, byte[] relatorioCampanha);

    @Query("select p.relatorioCampanha from Partner p where p.id = ?1")
    byte[] getRelatorio(Integer id);

}
