package teste.aular.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;
    private String petUuid;
    private String name;
    private String specie;
    private String breed;
    private LocalDate birthdate;
    private String healthDescription;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime deactivatedAt;

    @ManyToOne
    private PetTutor petTutor;

    //construtor
    public Pet() {
        this.petUuid = UUID.randomUUID().toString();
    }

    //getters setters
    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetUuid() {
        return petUuid;
    }

    public void setPetUuid(String petUuid) {
        this.petUuid = petUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getHealthDescription() {
        return healthDescription;
    }

    public void setHealthDescription(String healthDescription) {
        this.healthDescription = healthDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeactivatedAt() {
        return deactivatedAt;
    }

    public void setDeactivatedAt(LocalDateTime deactivatedAt) {
        this.deactivatedAt = deactivatedAt;
    }

    public PetTutor getPetTutor() {
        return petTutor;
    }

    public void setPetTutor(PetTutor petTutor) {
        this.petTutor = petTutor;
    }
}
