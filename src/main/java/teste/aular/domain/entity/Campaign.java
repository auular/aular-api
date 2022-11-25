package teste.aular.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int campaignId;

    private String type;

    private Double value;

    private Integer click;

    private LocalDate startedAt;

    private LocalDate finishedAt;

    @ManyToOne
    private Partner partner;

    @ManyToOne
    private Hotel hotel;

    public Campaign(int campaignId, String type, Double value, Integer click, LocalDate startedAt, LocalDate finishedAt) {
        this.campaignId = campaignId;
        this.type = type;
        this.value = value;
        this.click = click;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    public Campaign() {
    }

    //GETTERS SETTERS
    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDate getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDate finishedAt) {
        this.finishedAt = finishedAt;
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

