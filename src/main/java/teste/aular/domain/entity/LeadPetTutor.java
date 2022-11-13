package teste.aular.domain.entity;

import javax.persistence.*;

@Entity
public class LeadPetTutor {

    @Id
    private Integer leadPetTutorId;
    private String name;
    private String email;
    private String password;
    private String documentId;
    private String phoneNumber;

    public LeadPetTutor() {
    }

    public LeadPetTutor(Integer leadPetTutorId, String name, String email, String password, String documentId, String phoneNumber) {
        this.leadPetTutorId = leadPetTutorId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.documentId = documentId;
        this.phoneNumber = phoneNumber;
    }

    //GETTERS SETTERS
    public Integer getLeadPetTutorId() {
        return leadPetTutorId;
    }

    public void setLeadPetTutorId(Integer leadPetTutorId) {
        this.leadPetTutorId = leadPetTutorId;
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

    public String getPassword() {
        return password;
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

    @Override
    public String toString() {
        return "LeadPetTutor{" +
                "leadPetTutorId=" + leadPetTutorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", documentId='" + documentId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
