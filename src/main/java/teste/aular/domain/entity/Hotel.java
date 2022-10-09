package teste.aular.domain.entity;

import com.sun.xml.bind.v2.TODO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Hotel {


    @OneToOne
    private Plan plan;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    private UUID hotelUuid;

    @NotBlank
    @Size(min=6)
    private String hotelName;

    @Email
    private String hotemEmail;

    @NotBlank
    @Size(min=8)
    private String hotelPassword;

    @NotBlank
    private String hotelDocumentId;

    @NotNull
    private Double hotelRates;

    @NotBlank
    private String hotelPlanType;


    private Boolean hotelLoyalty;

    @NotBlank
    private String hotelPhoneNumber;

    @CreationTimestamp
    private LocalDate hotelCreatedAt;

    @UpdateTimestamp
    private LocalDate hotelEditedAt;

    private LocalDate hotelDeletedAt;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public UUID getHotelUuid() {
        return hotelUuid;
    }

    public void setHotelUuid(UUID hotelUuid) {
        this.hotelUuid = hotelUuid;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotemEmail() {
        return hotemEmail;
    }

    public void setHotemEmail(String hotemEmail) {
        this.hotemEmail = hotemEmail;
    }

    public String seePassword(){
        return hotelPassword;
    }

    public void setHotelPassword(String hotelPassword) {
        this.hotelPassword = hotelPassword;
    }

    public String getHotelDocumentId() {
        return hotelDocumentId;
    }

    public void setHotelDocumentId(String hotelDocumentId) {
        this.hotelDocumentId = hotelDocumentId;
    }

    public Double getHotelRates() {
        return hotelRates;
    }

    public void setHotelRates(Double hotelRates) {
        this.hotelRates = hotelRates;
    }

    public String getHotelPlanType() {
        return hotelPlanType;
    }

    public void setHotelPlanType(String hotelPlanType) {
        this.hotelPlanType = hotelPlanType;
    }

    public Boolean getHotelLoyalty() {
        return hotelLoyalty;
    }

    public void setHotelLoyalty(Boolean hotelLoyalty) {
        this.hotelLoyalty = hotelLoyalty;
    }

    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void setHotelPhoneNumber(String hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    public LocalDate getHotelCreatedAt() {
        return hotelCreatedAt;
    }

    public void setHotelCreatedAt(LocalDate hotelCreatedAt) {
        this.hotelCreatedAt = hotelCreatedAt;
    }

    public LocalDate getHotelEditedAt() {
        return hotelEditedAt;
    }

    public void setHotelEditedAt(LocalDate hotelEditedAt) {
        this.hotelEditedAt = hotelEditedAt;
    }

    public LocalDate getHotelDeletedAt() {
        return hotelDeletedAt;
    }

    public void setHotelDeletedAt(LocalDate hotelDeletedAt) {
        this.hotelDeletedAt = hotelDeletedAt;
    }


}
