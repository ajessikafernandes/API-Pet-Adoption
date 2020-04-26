package com.adopt.pet.service;

import com.adopt.pet.entity.Pet;
import com.adopt.pet.enums.*;
import com.adopt.pet.repository.PetRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PetServiceTest {

    @InjectMocks
    private PetService service;

    @Mock
    private PetRepository repository;

    @Before
    public void setUp(){
        Pet pet = getPet();
    }

    private Pet getPet(){
        Pet pet = new Pet();
        pet.setId(Long.valueOf(1));
        pet.setBreedName("Bulldog French");
        pet.setNamePet("Bilbo");
        pet.setTypePet(Species.DOG);
        pet.setGender(Gender.M);
        pet.setSize(Size.P);
        pet.setVaccinated(SelectOption.DO_NOT_KNOW);
        pet.setMicrochip(SelectOption.NO);
        pet.setCastrated(SelectOption.NO);
        pet.setSociality(SelectOption.YES);
        pet.setNeedsSpeciality(SelectOption.NO);
        pet.setExperienceAdopt(SelectOption.NO);
        pet.setStatus(Status.AVAILABLE);
        pet.setPetHistory("Little dog found abandoned on the street.");
        pet.setPetDiet("Premier Naturals");
        return pet;
    }

    @Test
    public void createNewPet(){
        Pet petIn = getPet();
        Mockito.when(repository.save(getPet())).thenReturn(petIn);
        service.createNewPet(petIn);
        System.out.println(petIn);
        Assert.assertEquals(petIn, getPet());
    }
}


