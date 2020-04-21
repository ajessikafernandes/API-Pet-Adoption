package com.adopt.pet.enums;

import lombok.Getter;

@Getter
public enum Gender {

    F(0, "Female"),
    M(1, "Male");

    private int id;
    private String message;

    Gender(int i, String active) {
    }

    void Errors(int id, String message) {
        this.id = id;
        this.message = message;
    }

}
