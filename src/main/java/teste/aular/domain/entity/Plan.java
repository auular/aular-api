package teste.aular.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    private String planType;

    private Double planValue;

    @ManyToOne
    private Hotel hotel;

    public Plan(Integer planId, String planType, Double planValue) {
        this.planId = planId;
        this.planType = planType;
        this.planValue = planValue;
    }

    //Getters Setters

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public Double getPlanValue() {
        return planValue;
    }

    public void setPlanValue(Double planValue) {
        this.planValue = planValue;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
