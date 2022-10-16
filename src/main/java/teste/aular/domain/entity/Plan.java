package teste.aular.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Plan {

    public enum PlanType {
        BRONZE,
        SILVER,
        GOLD;
        private Double planValue;

        PlanType(Double planValue) {
            this.planValue = planValue;
        }

        PlanType() {

        }


        public Double getPlanValue(PlanType plan) {
            switch (plan){
                case BRONZE:
                    planValue = 150.00;
                    break;
                case SILVER:
                    planValue = 250.00;
                    break;
                case GOLD:
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

    @NotBlank
    private String planType;

    private Double planValue;

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
}
