package teste.aular.domain.entity;

import javax.persistence.*;

@Entity
public class ServicesProvided {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int servicesProvidedId;

    private boolean servicePool;

    private boolean servicePlayground;

    private boolean serviceToys;

    private boolean serviceBath;

    private boolean serviceLeathering;

    private boolean serviceBedroom;

    private boolean serviceFood;

    private boolean serviceVisitation;

    private boolean serviceCam;

    private boolean serviceExercises;

    private boolean serviceTraining;

    private boolean serviceDentist;

    private boolean serviceVet;

    private boolean serviceMonitoring;

    private boolean dogsAcepted;

    private boolean catsAcepted;

    private boolean othersAcepted;

    private String averagePrice;

    private String guestsNumber;

    @ManyToOne
    private Hotel hotel;


    public ServicesProvided(int servicesProvidedId, boolean servicePool, boolean servicePlayground, boolean serviceToys,
                            boolean serviceBath, boolean serviceLeathering, boolean serviceBedroom, boolean serviceFood,
                            boolean serviceVisitation, boolean serviceCam, boolean serviceExercises, boolean serviceTraining,
                            boolean serviceDentist, boolean serviceVet, boolean serviceMonitoring, boolean dogsAcepted,
                            boolean catsAcepted, boolean othersAcepted, String averagePrice, String guestsNumber) {
        this.servicesProvidedId = servicesProvidedId;
        this.servicePool = servicePool;
        this.servicePlayground = servicePlayground;
        this.serviceToys = serviceToys;
        this.serviceBath = serviceBath;
        this.serviceLeathering = serviceLeathering;
        this.serviceBedroom = serviceBedroom;
        this.serviceFood = serviceFood;
        this.serviceVisitation = serviceVisitation;
        this.serviceCam = serviceCam;
        this.serviceExercises = serviceExercises;
        this.serviceTraining = serviceTraining;
        this.serviceDentist = serviceDentist;
        this.serviceVet = serviceVet;
        this.serviceMonitoring = serviceMonitoring;
        this.dogsAcepted = dogsAcepted;
        this.catsAcepted = catsAcepted;
        this.othersAcepted = othersAcepted;
        this.averagePrice = averagePrice;
        this.guestsNumber = guestsNumber;
    }

    public ServicesProvided() {
    }

    public int getServicesProvidedId() {
        return servicesProvidedId;
    }

    public void setServicesProvidedId(int servicesProvidedId) {
        this.servicesProvidedId = servicesProvidedId;
    }

    public boolean isServicePool() {
        return servicePool;
    }

    public void setServicePool(boolean servicePool) {
        this.servicePool = servicePool;
    }

    public boolean isServicePlayground() {
        return servicePlayground;
    }

    public void setServicePlayground(boolean servicePlayground) {
        this.servicePlayground = servicePlayground;
    }

    public boolean isServiceToys() {
        return serviceToys;
    }

    public void setServiceToys(boolean serviceToys) {
        this.serviceToys = serviceToys;
    }

    public boolean isServiceBath() {
        return serviceBath;
    }

    public void setServiceBath(boolean serviceBath) {
        this.serviceBath = serviceBath;
    }

    public boolean isServiceLeathering() {
        return serviceLeathering;
    }

    public void setServiceLeathering(boolean serviceLeathering) {
        this.serviceLeathering = serviceLeathering;
    }

    public boolean isServiceBedroom() {
        return serviceBedroom;
    }

    public void setServiceBedroom(boolean serviceBedroom) {
        this.serviceBedroom = serviceBedroom;
    }

    public boolean isServiceFood() {
        return serviceFood;
    }

    public void setServiceFood(boolean serviceFood) {
        this.serviceFood = serviceFood;
    }

    public boolean isServiceVisitation() {
        return serviceVisitation;
    }

    public void setServiceVisitation(boolean serviceVisitation) {
        this.serviceVisitation = serviceVisitation;
    }

    public boolean isServiceCam() {
        return serviceCam;
    }

    public void setServiceCam(boolean serviceCam) {
        this.serviceCam = serviceCam;
    }

    public boolean isServiceExercises() {
        return serviceExercises;
    }

    public void setServiceExercises(boolean serviceExercises) {
        this.serviceExercises = serviceExercises;
    }

    public boolean isServiceTraining() {
        return serviceTraining;
    }

    public void setServiceTraining(boolean serviceTraining) {
        this.serviceTraining = serviceTraining;
    }

    public boolean isServiceDentist() {
        return serviceDentist;
    }

    public void setServiceDentist(boolean serviceDentist) {
        this.serviceDentist = serviceDentist;
    }

    public boolean isServiceVet() {
        return serviceVet;
    }

    public void setServiceVet(boolean serviceVet) {
        this.serviceVet = serviceVet;
    }

    public boolean isServiceMonitoring() {
        return serviceMonitoring;
    }

    public void setServiceMonitoring(boolean serviceMonitoring) {
        this.serviceMonitoring = serviceMonitoring;
    }

    public boolean isDogsAcepted() {
        return dogsAcepted;
    }

    public void setDogsAcepted(boolean dogsAcepted) {
        this.dogsAcepted = dogsAcepted;
    }

    public boolean isCatsAcepted() {
        return catsAcepted;
    }

    public void setCatsAcepted(boolean catsAcepted) {
        this.catsAcepted = catsAcepted;
    }

    public boolean isOthersAcepted() {
        return othersAcepted;
    }

    public void setOthersAcepted(boolean othersAcepted) {
        this.othersAcepted = othersAcepted;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getGuestsNumber() {
        return guestsNumber;
    }

    public void setGuestsNumber(String guestsNumber) {
        this.guestsNumber = guestsNumber;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
