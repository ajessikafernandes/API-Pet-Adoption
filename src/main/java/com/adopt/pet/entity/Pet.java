package com.adopt.pet.entity;

import com.adopt.pet.enums.Status;
import com.adopt.pet.enums.Gender;
import com.adopt.pet.enums.SelectOption;
import com.adopt.pet.enums.Species;
import com.adopt.pet.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String breedName;
    private String namePet;
    private Species typePet;
    private Gender gender;
    private Size size;
    private SelectOption vaccinated;
    private SelectOption microchip;
    private SelectOption castrated;
    private SelectOption sociality;
    private SelectOption needsSpeciality;
    private SelectOption experienceAdopt;
    private Status status;
    private String petHistory;
    private String petDiet;

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(mappedBy = "petWithUser", cascade = CascadeType.ALL)
    private List<User> petWithUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public Species getTypePet() {
        return typePet;
    }

    public void setTypePet(Species typePet) {
        this.typePet = typePet;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public SelectOption getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(SelectOption vaccinated) {
        this.vaccinated = vaccinated;
    }

    public SelectOption getMicrochip() {
        return microchip;
    }

    public void setMicrochip(SelectOption microchip) {
        this.microchip = microchip;
    }

    public SelectOption getCastrated() {
        return castrated;
    }

    public void setCastrated(SelectOption castrated) {
        this.castrated = castrated;
    }

    public SelectOption getSociality() {
        return sociality;
    }

    public void setSociality(SelectOption sociality) {
        this.sociality = sociality;
    }

    public SelectOption getNeedsSpeciality() {
        return needsSpeciality;
    }

    public void setNeedsSpeciality(SelectOption needsSpeciality) {
        this.needsSpeciality = needsSpeciality;
    }

    public SelectOption getExperienceAdopt() {
        return experienceAdopt;
    }

    public void setExperienceAdopt(SelectOption experienceAdopt) {
        this.experienceAdopt = experienceAdopt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPetHistory() {
        return petHistory;
    }

    public void setPetHistory(String petHistory) {
        this.petHistory = petHistory;
    }

    public String getPetDiet() {
        return petDiet;
    }

    public void setPetDiet(String petDiet) {
        this.petDiet = petDiet;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<User> getPetWithUser() {
        return petWithUser;
    }

    public void setPetWithUser(List<User> petWithUser) {
        this.petWithUser = petWithUser;
    }
}
