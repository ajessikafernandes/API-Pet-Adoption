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
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class PetServiceTest {

    public static final int ID = 1;
    public static final String BREED_NAME = "Bulldog French";
    public static final String NAME_PET = "Bilbo";
    public static final Species TYPE_PET = Species.DOG;
    public static final Gender GENDER = Gender.M;
    public static final Size SIZE = Size.P;
    public static final SelectOption OPTION_DO_NOT_KNOW = SelectOption.DO_NOT_KNOW;
    public static final SelectOption OPTION_NO = SelectOption.NO;
    public static final SelectOption OPTION_YES = SelectOption.YES;
    public static final Status STATUS = Status.AVAILABLE;
    public static final String PET_HISTORY = "Little dog found abandoned on the street.";
    public static final String PET_DIET = "Premier Naturals";
    public static final Status STATUS_IN_PROCESS = Status.IN_PROCESS;

    public final Pet pet = getPet();

    @InjectMocks
    private PetService service;

    @Mock
    private PetRepository repository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    private Pet getPet(){
        Pet pet = new Pet();
        pet.setId((long) ID);
        pet.setBreedName(BREED_NAME);
        pet.setNamePet(NAME_PET);
        pet.setTypePet(TYPE_PET);
        pet.setGender(GENDER);
        pet.setSize(SIZE);
        pet.setVaccinated(OPTION_DO_NOT_KNOW);
        pet.setMicrochip(OPTION_NO);
        pet.setCastrated(OPTION_NO);
        pet.setSociality(OPTION_YES);
        pet.setNeedsSpeciality(OPTION_NO);
        pet.setExperienceAdopt(OPTION_NO);
        pet.setStatus(STATUS);
        pet.setPetHistory(PET_HISTORY);
        pet.setPetDiet(PET_DIET);
        return pet;
    }

    @Test
    public void petIsPresent(){
        Mockito.when(repository.findById(pet.getId())).thenReturn(Optional.of(pet));
        Assert.assertEquals("Bulldog French", pet.getBreedName());
    }

    @Test
    public void findPetById(){
        Mockito.when(repository.findById((long) ID)).thenReturn(Optional.of(pet));
        Optional<Pet> findByIdPet = service.findPetById(pet.getId());
        Assert.assertTrue(findByIdPet.isPresent());
    }

    @Test
    public void createNewPet(){
        Mockito.when(repository.save(getPet())).thenReturn(pet);
        service.createNewPet(pet);
        Assert.assertEquals(pet, getPet());
    }

    @Test
    public void alterDataPet(){
        petIsPresent();
        pet.setStatus(STATUS_IN_PROCESS);
        service.updatePetData(pet, pet.getId());
        Assert.assertEquals(STATUS_IN_PROCESS, pet.getStatus());
    }

    @Test
    public void deletePet(){
        boolean deleteOperation = service.deletePet(pet.getId());
        Assert.assertTrue(deleteOperation);
    }
}


