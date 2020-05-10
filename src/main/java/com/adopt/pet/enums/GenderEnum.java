package com.adopt.pet.enums;

public enum GenderEnum {

    FEMALE("Female"),
    MALE("Male");

    private String value;

    GenderEnum(String value) {
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
