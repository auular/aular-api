package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teste.aular.domain.entity.Campaign;
import java.util.List;
import java.util.Optional;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    List<Campaign> findAllByPartnerPartnerId(Integer partnerId);

    @Query("SELECT new teste.aular.domain.entity.Campaign(c.campaignId, c.type, c.value, c.click, c.startedAt, c.finishedAt ) " +
            "FROM Campaign c " +
            "WHERE c.hotel.hotelId = ?1 ")
    Optional<Campaign> getSimpleCampaign(int hotelId);
}
