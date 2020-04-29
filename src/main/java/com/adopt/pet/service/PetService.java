package com.adopt.pet.service;

import com.adopt.pet.entity.Pet;
import com.adopt.pet.exceptions.PetByIdNotFoundException;
import com.adopt.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository repository;

    public boolean createNewPet(Pet pet){
        repository.save(pet);
        return true;
    }

    public Optional<Pet> findPetById(Long id){
        Optional<Pet> petIn = repository.findById(id);
        validatePetIsPresent(petIn);
        return petIn;
    }

    public Pet updatePetData(Pet pet, Long id){
        Optional<Pet> petIn = repository.findById(id);
        validatePetIsPresent(petIn);
        repository.save(pet);
        return pet;
    }

    public boolean deletePet(Long id){
        repository.deleteById(id);
        return true;
    }

    private void validatePetIsPresent(Optional<Pet> pet) {
        if (StringUtils.isEmpty(pet)) {
            throw new PetByIdNotFoundException("Pet id not found.");
        }
    }

}
