package com.adopt.pet.entity;

import com.adopt.pet.enums.StateEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 9, nullable = false)
    private String zip;
    @Column(length = 40, nullable = false)
    private String city;
    @Column(length = 2, nullable = false)
    private StateEnum uf;

    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    private Pet pet;

    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
}
