package com.adopt.pet.enums;

import java.util.Objects;

public enum SelectInterviewEnum {

    YES,
    NO;

    public static SelectOptionEnum byValue( String status ) {
        for (SelectOptionEnum type : SelectOptionEnum.values()) {
            if (type.name().equalsIgnoreCase(status)) {
                return type;
            }
        }
        return null;
    }

    public static boolean optionIsNull(SelectOptionEnum selectOptionEnum){
        return Objects.isNull(selectOptionEnum);
    }

}
