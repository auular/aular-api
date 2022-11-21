package teste.aular.response;

import javax.validation.constraints.NotBlank;

public class HotelAddressResponse {

    private int hotelId;
    private String hotelUuid;
    private String addressCode;
    private String addressStreet;
    private String addressNumber;
    private String addressComplement;
    private String addressDistrict;
    private String addressCity;
    private String addressState;

    public HotelAddressResponse(
            int hotelId,
            String hotelUuid,
            String addressCode,
            String addressStreet,
            String addressNumber,
            String addressComplement,
            String addressDistrict,
            String addressCity,
            String addressState
    ) {
        this.hotelId = hotelId;
        this.hotelUuid = hotelUuid;
        this.addressCode = addressCode;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
        this.addressComplement = addressComplement;
        this.addressDistrict = addressDistrict;
        this.addressCity = addressCity;
        this.addressState = addressState;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelUuid() {
        return hotelUuid;
    }

    public void setHotelUuid(String hotelUuid) {
        this.hotelUuid = hotelUuid;
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
}
