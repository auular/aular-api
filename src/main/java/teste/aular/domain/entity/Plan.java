package teste.aular.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Plan {

    public enum PlanType {
        Bronze,
        Silver,
        Gold;
        private Double planValue;

        PlanType(Double planValue) {
            this.planValue = planValue;
        }

        PlanType() {

        }

        public Double getPlanValue(PlanType plan) {
            switch (plan){
                case Bronze:
                    planValue = 150.00;
                    break;
                case Silver:
                    planValue = 250.00;
                    break;
                case Gold:
                    planValue = 350.00;
                    break;
                default:
                    System.err.println("Invalid plan");
                    break;
            }
            return planValue;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    private String planType;

    private Double planValue;

    @ManyToOne
    private Hotel hotel;


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

    public void setPlanValue(Double planValue, PlanType plan) {

        this.planValue = plan.getPlanValue(plan);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
