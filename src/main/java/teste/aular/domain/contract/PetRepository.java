package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import teste.aular.domain.entity.Pet;
import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findAllByPetTutorPetTutorId(Integer petTutorId);

    @Query("SELECT new teste.aular.domain.entity.Pet(p.petId, p.petUuid, p.name, p.specie, p.breed, p.birthdate, " +
            "p.healthDescription, p.createdAt, p.updatedAt, p.deactivatedAt) " +
            "FROM Pet p " +
            "WHERE p.petTutor.petTutorId = ?1 ")
    Optional<Pet> getSimplePetByPetTutorId(int petTutorId);
}
