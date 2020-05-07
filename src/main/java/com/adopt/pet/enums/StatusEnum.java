package com.adopt.pet.enums;

public enum StatusEnum {

    AVAILABLE("Disponivel"),
    IN_PROCESS("Em processo"),
    ADOPTED("Adotado");

    private String value;

    StatusEnum(final String value) {
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
