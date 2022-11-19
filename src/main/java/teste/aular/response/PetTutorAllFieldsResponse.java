package teste.aular.response;

import teste.aular.domain.entity.*;

public class PetTutorAllFieldsResponse {

    private PetTutor petTutor;
    private Pet pet;
    private Address address;


    public PetTutorAllFieldsResponse(PetTutor petTutor, Pet pet, Address address) {
        this.petTutor = petTutor;
        this.pet = pet;
        this.address = address;
    }

    public PetTutor getPetTutor() {
        return petTutor;
    }

    public void setPetTutor(PetTutor petTutor) {
        this.petTutor = petTutor;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
