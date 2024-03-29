package teste.aular.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @NotBlank
    private String addressCode;

    @NotBlank
    private String addressStreet;

    @NotBlank
    private String addressNumber;

    private String addressComplement;

    private String addressDistrict;

    private  String addressCity;

    private String addressState;

    @OneToOne
    private PetTutor petTutor;

    @OneToOne
    private Partner partner;

    @OneToOne
    private Hotel hotel;

    public Address(Integer addressId, String addressCode, String addressStreet, String addressNumber, String addressComplement, String addressDistrict, String addressCity, String addressState) {
        this.addressId = addressId;
        this.addressCode = addressCode;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
        this.addressComplement = addressComplement;
        this.addressDistrict = addressDistrict;
        this.addressCity = addressCity;
        this.addressState = addressState;
    }



    public Address() {
    }

    //Getters Setters
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public String getAddressDistrict() {
        return addressDistrict;
    }

    public void setAddressDistrict(String addressDistrict) {
        this.addressDistrict = addressDistrict;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public PetTutor getPetTutor() {
        return petTutor;
    }

    public void setPetTutor(PetTutor petTutor) {
        this.petTutor = petTutor;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
