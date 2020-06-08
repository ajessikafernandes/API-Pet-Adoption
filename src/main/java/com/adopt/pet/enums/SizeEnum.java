package com.adopt.pet.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum SizeEnum {

    PEQUENO_PORTE,
    MEDIO_PORTE,
    GRANDE_PORTE;

    public static SizeEnum byValue( String value ) {
        for (SizeEnum type : SizeEnum.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }

    public static boolean optionIsNull(SizeEnum sizeEnum){
        return Objects.isNull(sizeEnum);
    }

}
