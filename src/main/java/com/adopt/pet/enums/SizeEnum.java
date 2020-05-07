package com.adopt.pet.enums;

import lombok.Getter;

@Getter
public enum SizeEnum {

    PEQUENO_PORTE("Pequeno porte"),
    MEDIO_PORTE("Médio porte"),
    GRANDE_PORTE("Grande porte");

    private String value;

    SizeEnum(final String value) {
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
