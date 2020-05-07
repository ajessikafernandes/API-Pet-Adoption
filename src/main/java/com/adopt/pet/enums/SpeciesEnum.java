package com.adopt.pet.enums;

import lombok.Getter;

@Getter
public enum SpeciesEnum {

    DOG("Canino"),
    CAT("Felino");

    private String value;

    SpeciesEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

}
