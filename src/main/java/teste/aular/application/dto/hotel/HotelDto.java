package teste.aular.application.dto.hotel;

public class HotelDto {

    private Integer hotelId;

    private String hotelUuid;

    private String name;

    private String email;

    private String phoneNumber;

    public HotelDto(Integer hotelId, String hotelUuid, String name, String email, String phoneNumber) {
        this.hotelId = hotelId;
        this.hotelUuid = hotelUuid;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
