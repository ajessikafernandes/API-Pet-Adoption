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

}
