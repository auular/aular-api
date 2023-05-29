package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teste.aular.domain.entity.PetTutor;
import teste.aular.response.PetTutorAllFieldsResponse;
import javax.transaction.Transactional;
import java.util.Optional;

public interface PetTutorRepository extends JpaRepository<PetTutor, Integer> {

    boolean existsByDocumentId(String documentId);

    //@Transactional para que o EntityManager reconheça esse método como uma transação
    @Transactional
    void deleteByDocumentId(String documentId);

    boolean existsByPetTutorUuid(String uuid);

    @Query("SELECT new teste.aular.response.PetTutorAllFieldsResponse(pt, p, a) " +
            "FROM PetTutor pt " +
            "JOIN Pet p ON pt.petTutorId = p.petTutor.petTutorId " +
            "JOIN Address a ON pt.petTutorId = a.petTutor.petTutorId " +
            "WHERE pt.petTutorId = ?1 "
    )
    Optional<PetTutorAllFieldsResponse> getPetTutorAllFieldsResponse(int petTutorId) ;

    Optional<PetTutor> findByPetTutorUuid(String petTutorUuid);
}
