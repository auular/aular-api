package teste.aular.response;

import teste.aular.domain.entity.*;

public class HotelAllFieldsResponse {

    private Hotel hotel;
    private Campaign campaign;
    private Plan plan;
    private Address address;

    private ServicesProvided servicesProvided;


    public HotelAllFieldsResponse(Hotel hotel, Campaign campaign, Plan plan, Address address, ServicesProvided servicesProvided) {
        this.hotel = hotel;
        this.campaign = campaign;
        this.plan = plan;
        this.address = address;
        this.servicesProvided = servicesProvided;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ServicesProvided getServicesProvided() {
        return servicesProvided;
    }

    public void setServicesProvided(ServicesProvided servicesProvided) {
        this.servicesProvided = servicesProvided;
    }
}
