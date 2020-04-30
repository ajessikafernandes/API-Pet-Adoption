package com.adopt.pet.controller;

import com.adopt.pet.entity.Pet;
import com.adopt.pet.exceptions.IdCannotBeNullException;
import com.adopt.pet.exceptions.PetByIdNotFoundException;
import com.adopt.pet.exceptions.PetCannotBeNullException;
import com.adopt.pet.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "pet/")
public class PetController {

    PetService service;

    @GetMapping("{id}")
    public ResponseEntity<Pet> findPetById(@PathVariable Long id) {
        if (Objects.isNull(id)){
            throw new PetCannotBeNullException("Pet cannot be null");
        }
        return service.findPetById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("new")
    public ResponseEntity createdPet(@RequestBody Pet pet) {
        if (Objects.isNull(pet)){
            throw new PetCannotBeNullException("Pet cannot be null");
        }
        service.createNewPet(pet);
        return new ResponseEntity(pet, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletePet(@PathVariable("id") Long id) {
        if (Objects.isNull(id)){
            throw new IdCannotBeNullException("Id cannot be null");
        }
        service.deletePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Object> updatePetData(@RequestBody @Valid Pet pet, @PathVariable(value = "id") Long id) {
        Optional<Pet> petIn = service.findPetById(id);
        if (petIn.isPresent()) {
            Pet pet1 = service.updatePetData(pet, id);
            return ResponseEntity.ok(service.updatePetData(pet1, id));
        }
        return ResponseEntity.badRequest().body(new PetByIdNotFoundException("Pet not found!"));
    }

}
