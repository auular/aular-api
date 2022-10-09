package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.aular.domain.entity.Hotel;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

     Boolean findByDocumentId(String documentId);

}
