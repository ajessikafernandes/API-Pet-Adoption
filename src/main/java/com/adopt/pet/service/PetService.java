package com.adopt.pet.service;

import com.adopt.pet.entity.Pet;
import com.adopt.pet.exceptions.IdCannotBeNullException;
import com.adopt.pet.exceptions.PetByIdNotFoundException;
import com.adopt.pet.exceptions.PetCannotBeNullException;
import com.adopt.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository repository;

    public boolean createNewPet(Pet pet) {
        validatePetNotNull(pet);
        repository.save(pet);
        return true;
    }

    public Optional<Pet> findPetById(Long id) {
        validatePetIdNotNull(id);
        Optional<Pet> petIn = repository.findById(id);
        if (!petIn.isPresent()) {
            throw new PetByIdNotFoundException("Informed pet id not found");
        }
        return petIn;

    }

    public Pet updatePetData(Pet pet, Long id) {
        validatePetNotNull(pet);
        validatePetIdNotNull(id);
        Optional<Pet> petIn = repository.findById(id);
        if (petIn.isPresent()) {
            repository.save(pet);
            return pet;
        }
        throw new PetByIdNotFoundException("Informed pet id not found");
    }

    public boolean deletePet(Long id) {
        validatePetIdNotNull(id);
        repository.deleteById(id);
        return true;
    }

    private Boolean validatePetIdNotNull(Long id) {
        if (id != null) {
            return true;
        }
        throw new IdCannotBeNullException("Pet id not found.");
    }

    private Boolean validatePetNotNull(Pet pet) {
        if (Objects.isNull(pet)) {
            throw new PetCannotBeNullException("Pet cannot be null");
        }
        return true;
    }

}
