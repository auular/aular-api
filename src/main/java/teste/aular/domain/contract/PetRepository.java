package teste.aular.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.aular.domain.entity.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findAllByPetTutorPetTutorId(Integer petTutorId);
}
