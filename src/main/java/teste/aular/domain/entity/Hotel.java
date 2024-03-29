package teste.aular.domain.entity;

import com.sun.xml.bind.v2.TODO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Entity
//@Table(name = "tab_hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;

    private String hotelUuid;

    @NotBlank
    @Size(min = 6)
    private String name;

    @Email
    private String email;

//    @NotBlank
//    @Size(min = 8)
    private String password;

    @NotBlank
    @Column(updatable = false)
    private String documentId;

    private Boolean fidelity;

    private Double rates;

    @NotBlank
    private String phoneNumber;

    @Column(length=512)
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime deactivatedAt;

    private boolean active;

    private boolean isAuthenticated;
    private URL imageByteArray;

    public Hotel() {
        this.hotelUuid = UUID.randomUUID().toString();
        this.active = true;
        this.isAuthenticated = false;

    }

    public Hotel(int hotelId, String hotelUuid, String name, String email, String documentId,
                 Boolean fidelity, Double rates, String phoneNumber, String description, LocalDateTime createdAt,
                 LocalDateTime updatedAt, LocalDateTime deactivatedAt, boolean active, boolean isAuthenticated) {
        this.hotelId = hotelId;
        this.hotelUuid = hotelUuid;
        this.name = name;
        this.email = email;
        this.documentId = documentId;
        this.fidelity = fidelity;
        this.rates = rates;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deactivatedAt = deactivatedAt;
        this.active = active;
        this.isAuthenticated = isAuthenticated;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelUuid() {
        return hotelUuid;
    }

    public void setHotelUuid(String hotelUuid) {
        this.hotelUuid = hotelUuid;
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

    public Boolean getFidelity() {
        return fidelity;
    }

    public void setFidelity(Boolean fidelity) {
        this.fidelity = fidelity;
    }

    public Double getRates() {
        return rates;
    }

    public void setRates(Double rates) {
        this.rates = rates;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setActive(Boolean active) {
        this.active = active;
    }

    public boolean getAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public boolean authenticateHotel(String hotelEmail, String hotelPassword) {
        isAuthenticated = hotelEmail.equals(this.email) && hotelPassword.equals(this.password);
        return isAuthenticated;
    }

    public String seePassword(){
        return this.password;
    }

    public URL getImageByteArray() {
        return this.imageByteArray;
    }

    public void setImageByteArray(URL image) {
        this.imageByteArray = image;
    }

    public String mapToHotelSlug() {
        String slug = Arrays.stream(this.name.toLowerCase().split(" ")).reduce("", (partialString, element) -> partialString + "-" + element);
        return removeFirstHyphen(slug);
    }

    public String removeFirstHyphen(String slug) {
        return slug.replaceFirst("-", "");
    }

}