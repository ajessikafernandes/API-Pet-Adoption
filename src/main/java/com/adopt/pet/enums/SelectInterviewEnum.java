package com.adopt.pet.enums;

import java.util.Objects;

public enum SelectInterviewEnum {

    YES,
    NO;

    public static SelectInterviewEnum byValue( String value) {
        for (SelectInterviewEnum type : SelectInterviewEnum.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }

    public static boolean optionIsNull(SelectInterviewEnum selectInterviewEnum){
        return Objects.isNull(selectInterviewEnum);
    }

}
