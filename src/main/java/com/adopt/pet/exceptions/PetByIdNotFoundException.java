package com.adopt.pet.exceptions;

public class PetByIdNotFoundException extends RuntimeException {

    public PetByIdNotFoundException(String message){
        super(message);
    }

}
