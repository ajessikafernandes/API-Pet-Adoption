package com.adopt.pet.enums;

import java.util.Objects;

public enum SelectInterviewEnum {

    YES,
    NO;

    public static SelectInterviewEnum byValue( String status ) {
        for (SelectInterviewEnum type : SelectInterviewEnum.values()) {
            if (type.name().equalsIgnoreCase(status)) {
                return type;
            }
        }
        return null;
    }

    public static boolean optionIsNull(SelectInterviewEnum selectInterviewEnum){
        return Objects.isNull(selectInterviewEnum);
    }

}
