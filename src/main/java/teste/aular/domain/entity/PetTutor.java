package teste.aular.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class PetTutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPetTutor;

    @NotBlank
    @Size(min = 3)
    private String name;
    @Email
    private String email;
    private String password;
    private String documentId;
    private String phone_number;


    //@CreationTimestamp
    private LocalDateTime created_at;

    //@UpdateTimestamp
    private LocalDateTime updated_at;

    private LocalDateTime deactivated_at;

    private Boolean active;


    public PetTutor() {
        this.active = true;
    }

    //GETTERS SETTERS
    public Integer getIdPetTutor() {
        return idPetTutor;
    }

    public void setIdPetTutor(Integer idPetTutor) {
        this.idPetTutor = idPetTutor;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getDeactivated_at() {
        return deactivated_at;
    }

    public void setDeactivated_at(LocalDateTime deactivated_at) {
        this.deactivated_at = deactivated_at;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
