package teste.aular.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
//@Table(name = "tab_partner")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partnerId;
    private String partnerUuid;
    private String name;
    private String email;
    @NotBlank
    private String password;
    private String documentId;
    private boolean fidelity;
    private String phoneNumber;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deactivatedAt;
    private boolean active;

    private Boolean isAuthenticated;

    private int numberOfCampaigns;

    @JsonIgnore
    @Column(length = 10 * 1024 *1024)
    private byte[] relatorioCampanha;


    protected Partner() {
        this.partnerUuid = UUID.randomUUID().toString();
        this.active = true;
        this.isAuthenticated = false;
    }

    //GETTERS SETTERS
    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerUuid() {
        return partnerUuid;
    }

    public void setPartnerUuid(String partnerUuid) {
        this.partnerUuid = partnerUuid;
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

    public boolean isFidelity() {
        return fidelity;
    }

    public void setFidelity(boolean fidelity) {
        this.fidelity = fidelity;
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

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Boolean getAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public boolean authenticatePartner(String partnerEmail, String partnerPassword) {
        isAuthenticated = partnerEmail.equals(this.email) && partnerPassword.equals(this.password);
        return isAuthenticated;
    }

    public int getNumberOfCampaigns() {
        return numberOfCampaigns;
    }

    public void setNumberOfCampaigns(int numberOfCampaigns) {
        this.numberOfCampaigns = numberOfCampaigns;
    }

    public byte[] getRelatorioCampanha() {
        return relatorioCampanha;
    }

    public void setRelatorioCampanha(byte[] relatorioCampanha) {
        this.relatorioCampanha = relatorioCampanha;
    }
}
