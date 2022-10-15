package teste.aular.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tab_pet_tutor")
public class PetTutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petTutorId;

    private String petTutorUuid;
    @NotBlank
    @Size(min = 3)
    private String name;
    @Email
    private String email;
    private String password;
    private String documentId;
    private String phoneNumber;


    //@CreationTimestamp
    private LocalDateTime createdAt;

    //@UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime deactivatedAt;

    private Boolean active;


    public PetTutor() {
        this.active = true;
    }

    //GETTERS SETTERS

    public Integer getPetTutorId() {
        return petTutorId;
    }

    public void setPetTutorId(Integer petTutorId) {
        this.petTutorId = petTutorId;
    }

    public String getPetTutorUuid() {
        return petTutorUuid;
    }

    public void setPetTutorUuid(String petTutorUuid) {
        this.petTutorUuid = petTutorUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
