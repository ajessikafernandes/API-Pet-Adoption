package com.adopt.pet.enums;

import java.util.Objects;

public enum SelectOptionEnum {

    YES,
    NO,
    DO_NOT_KNOW;

    public static SelectOptionEnum byValue( String value ) {
        for (SelectOptionEnum type : SelectOptionEnum.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }

    public static boolean optionIsNull(SelectOptionEnum selectOptionEnum){
        return Objects.isNull(selectOptionEnum);
    }

}
