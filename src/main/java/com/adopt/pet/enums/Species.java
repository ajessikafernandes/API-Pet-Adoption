package com.adopt.pet.enums;

import lombok.Getter;

@Getter
public enum Species {

    DOG(0, "Canino"),
    CAT(1, "Felino");

    private int id;
    private String message;

    Species(int i, String active) {
    }

    void Errors(int id, String message) {
        this.id = id;
        this.message = message;
    }

}
