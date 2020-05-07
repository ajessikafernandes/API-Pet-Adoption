package com.adopt.pet.enums;

public enum SelectOptionEnum {

    YES("Yes"),
    NO("No"),
    DO_NOT_KNOW("Do not know");

    private String value;

    SelectOptionEnum(final String value) {
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
