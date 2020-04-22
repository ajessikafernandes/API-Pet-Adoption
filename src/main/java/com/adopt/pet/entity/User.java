package com.adopt.pet.entity;

import com.adopt.pet.enums.SelectInterview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Length(min = 8, message = "*Your password must have at least 8 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    @NotEmpty(message = "*Please provide your Fist Name")
    private String firstName;
    @NotEmpty(message = "*Please provide your Last Name")
    private String lastName;
    @NotEmpty(message = "*Please provide your Phone")
    private String phone;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Interview interview;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PET_USER", joinColumns = {@JoinColumn(name = "USER_ID_USER")}, inverseJoinColumns = {
            @JoinColumn(name = "PET_ID_PET")})
    private List<Pet> petWithUser = new ArrayList<>();

}
