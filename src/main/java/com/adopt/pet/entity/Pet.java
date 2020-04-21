package com.adopt.pet.entity;

import com.adopt.pet.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

//    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
//    private Address address;
//
//    //Pendente o envio por postman,
//    @ManyToMany(mappedBy = "petWithUser", cascade = CascadeType.ALL)
//    private List<User> petWithUser;

}
