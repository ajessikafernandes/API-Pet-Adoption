package com.adopt.pet.enums;

import java.util.Objects;

public enum GenderEnum {

    FEMALE,
    MALE;

    public static GenderEnum byValue( String value ) {
        for (GenderEnum type : GenderEnum.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }

    public static boolean optionIsNull(GenderEnum genderEnum){
        return Objects.isNull(genderEnum);
    }

}
