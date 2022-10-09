package teste.aular.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Address {
    @OneToOne
    private Hotel hotel;

    @OneToOne
    private PetTutor petTutor;

    @OneToOne
    private Partner partner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @NotBlank
    private String addressCode;

    @NotBlank
    private String addressStreet;

    @NotBlank
    private String addressNumber;

    @NotBlank
    private String addressComplement;

    @NotBlank
    private String addressDistrict;

    @NotBlank
    private  String addressCity;

    @NotBlank
    private String addressState;

}
