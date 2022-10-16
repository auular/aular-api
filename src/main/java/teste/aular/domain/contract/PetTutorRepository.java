package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.aular.domain.entity.PetTutor;

import javax.transaction.Transactional;
import java.util.UUID;

public interface PetTutorRepository extends JpaRepository<PetTutor, String> {

    boolean existsByDocumentId(String documentId);

    //@Transactional para que o EntityManager reconheça esse método como uma transação
    @Transactional
    void deleteByDocumentId(String documentId);

    boolean existsByPetTutorUuid(String uuid);
}
