package com.adopt.pet.enums;

import java.util.Objects;

public enum GenderEnum {

    FEMALE,
    MALE;

    public static GenderEnum byValue( String status ) {
        for (GenderEnum type : GenderEnum.values()) {
            if (type.name().equalsIgnoreCase(status)) {
                return type;
            }
        }
        return null;
    }

    public static boolean optionIsNull(GenderEnum genderEnum){
        return Objects.isNull(genderEnum);
    }

}
