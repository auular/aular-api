package teste.aular.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.br.CNPJ;
import teste.aular.domain.entity.Hotel;
import teste.aular.domain.entity.PetTutor;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    @OneToOne
    @JoinColumn(name = "petTutorId")
    private PetTutor author;
    private String comment;
    @Transient
    private String hotelUuid;

    public Comment() {
    }

    public Comment(PetTutor author, String comment) {
        this.author = author;
        this.comment = comment;
    }

    public PetTutor getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public void setAuthor(PetTutor author) {
        this.author = author;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setHotelUuid(String hotelUuid) {
        this.hotelUuid = hotelUuid;
    }

    public String getHotelUuid() {
        return this.hotelUuid;
    }
}
