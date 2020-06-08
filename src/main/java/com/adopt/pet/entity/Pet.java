package com.adopt.pet.entity;

import com.adopt.pet.enums.StatusEnum;
import com.adopt.pet.enums.GenderEnum;
import com.adopt.pet.enums.SelectOptionEnum;
import com.adopt.pet.enums.SpeciesEnum;
import com.adopt.pet.enums.SizeEnum;
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
    private SpeciesEnum typePet;
    private GenderEnum gender;
    private SizeEnum size;
    private SelectOptionEnum vaccinated;
    private SelectOptionEnum microchip;
    private SelectOptionEnum castrated;
    private SelectOptionEnum sociality;
    private SelectOptionEnum needsSpeciality;
    private SelectOptionEnum experienceAdopt;
    private StatusEnum status;
    private String petHistory;
    private String petDiet;

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(mappedBy = "petWithUser", cascade = CascadeType.ALL)
    private List<User> petWithUser;

}
