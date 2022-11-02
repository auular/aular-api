package teste.aular.application.dto;

public class UpdatePartner {

    private int partnerId;
    private String email;

    private boolean fidelity;

    private String phoneNumber;


    public UpdatePartner(int partnerId, String email, boolean fidelity, String phoneNumber) {
        this.partnerId = partnerId;
        this.email = email;
        this.fidelity = fidelity;
        this.phoneNumber = phoneNumber;
    }

    //getters setters

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
