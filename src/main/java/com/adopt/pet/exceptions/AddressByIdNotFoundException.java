package com.adopt.pet.exceptions;

public class AddressByIdNotFoundException extends RuntimeException {

    public AddressByIdNotFoundException(String message){
        super(message);
    }

}
