package com.adopt.pet.enums;

import java.util.Objects;

public enum StatusEnum {

    AVAILABLE,
    IN_PROCESS,
    ADOPTED;

    public static StatusEnum byValue( String value ) {
        for (StatusEnum type : StatusEnum.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }

    public static boolean optionIsNull(StatusEnum value){
        return Objects.isNull(value);
    }
}
