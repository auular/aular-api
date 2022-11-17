package teste.aular.domain.entity;

import javax.persistence.*;

@Entity
public class ServicesProvided {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int servicesProvidedId;

    private boolean service_pool;

    private boolean service_playground;

    private boolean service_toys;

    private boolean service_bath;

    private boolean service_leathering;

    private boolean service_bedroom;

    private boolean service_food;

    private boolean service_visitation;

    private boolean service_cam;

    private boolean service_exercises;

    private boolean service_training;

    private boolean service_dentist;

    private boolean service_vet;

    private boolean service_monitoring;

    @ManyToOne
    private Hotel hotel;



    public int getServicesProvidedId() {
        return servicesProvidedId;
    }

    public void setServicesProvidedId(int servicesProvidedId) {
        this.servicesProvidedId = servicesProvidedId;
    }

    public boolean isService_pool() {
        return service_pool;
    }

    public void setService_pool(boolean service_pool) {
        this.service_pool = service_pool;
    }

    public boolean isService_playground() {
        return service_playground;
    }

    public void setService_playground(boolean service_playground) {
        this.service_playground = service_playground;
    }

    public boolean isService_toys() {
        return service_toys;
    }

    public void setService_toys(boolean service_toys) {
        this.service_toys = service_toys;
    }

    public boolean isService_bath() {
        return service_bath;
    }

    public void setService_bath(boolean service_bath) {
        this.service_bath = service_bath;
    }

    public boolean isService_leathering() {
        return service_leathering;
    }

    public void setService_leathering(boolean service_leathering) {
        this.service_leathering = service_leathering;
    }

    public boolean isService_bedroom() {
        return service_bedroom;
    }

    public void setService_bedroom(boolean service_bedroom) {
        this.service_bedroom = service_bedroom;
    }

    public boolean isService_food() {
        return service_food;
    }

    public void setService_food(boolean service_food) {
        this.service_food = service_food;
    }

    public boolean isService_visitation() {
        return service_visitation;
    }

    public void setService_visitation(boolean service_visitation) {
        this.service_visitation = service_visitation;
    }

    public boolean isService_cam() {
        return service_cam;
    }

    public void setService_cam(boolean service_cam) {
        this.service_cam = service_cam;
    }

    public boolean isService_exercises() {
        return service_exercises;
    }

    public void setService_exercises(boolean service_exercises) {
        this.service_exercises = service_exercises;
    }

    public boolean isService_training() {
        return service_training;
    }

    public void setService_training(boolean service_training) {
        this.service_training = service_training;
    }

    public boolean isService_dentist() {
        return service_dentist;
    }

    public void setService_dentist(boolean service_dentist) {
        this.service_dentist = service_dentist;
    }

    public boolean isService_vet() {
        return service_vet;
    }

    public void setService_vet(boolean service_vet) {
        this.service_vet = service_vet;
    }

    public boolean isService_monitoring() {
        return service_monitoring;
    }

    public void setService_monitoring(boolean service_monitoring) {
        this.service_monitoring = service_monitoring;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
