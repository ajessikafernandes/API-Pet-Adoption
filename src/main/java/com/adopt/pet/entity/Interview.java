package com.adopt.pet.entity;

import com.adopt.pet.enums.SelectInterviewEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private SelectInterviewEnum hasExperience;
    private SelectInterviewEnum hasPets;
    private Integer howManyPets;
    private SelectInterviewEnum hasCompany;
    private Long hoursAlone = TimeUnit.HOURS.toHours(0);
    private String aboutPetsBehavior;

    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
}
