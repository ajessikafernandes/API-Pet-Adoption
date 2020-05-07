package com.adopt.pet.enums;

public enum SelectInterviewEnum {

    YES("Yes"),
    NO("No");

    private String value;

    SelectInterviewEnum(final String value) {
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
