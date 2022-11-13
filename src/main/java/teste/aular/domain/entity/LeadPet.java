package teste.aular.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class LeadPet {
    @Id
    private Integer petId;
    private String name;
    private String specie;
    private String breed;
    private LocalDate birthdate;
    private String healthDescription;
    @ManyToOne
    private LeadPetTutor leadPetTutor;

    public LeadPet() {
    }

    public LeadPet(Integer petId, String name, String specie, String breed, LocalDate birthdate, String healthDescription, LeadPetTutor leadPetTutor) {
        this.petId = petId;
        this.name = name;
        this.specie = specie;
        this.breed = breed;
        this.birthdate = birthdate;
        this.healthDescription = healthDescription;
        this.leadPetTutor = leadPetTutor;
    }

    //getters setters
    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
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

    public LeadPetTutor getLeadPetTutor() {
        return leadPetTutor;
    }

    public void setLeadPetTutor(LeadPetTutor leadPetTutor) {
        this.leadPetTutor = leadPetTutor;
    }

    @Override
    public String toString() {
        return "LeadPet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", specie='" + specie + '\'' +
                ", breed='" + breed + '\'' +
                ", birthdate=" + birthdate +
                ", healthDescription='" + healthDescription + '\'' +
                ", leadPetTutor=" + leadPetTutor +
                '}';
    }
}
