package com.adopt.pet.enums;

import lombok.Getter;

@Getter
public enum Size {

    P(0, "Pequeno porte"),
    M(1, "Médio porte"),
    G(2, "Grande porte");

    private int id;
    private String message;

    Size(int i, String active) {
    }

    void Errors(int id, String message) {
        this.id = id;
        this.message = message;
    }
}
