package com.adopt.pet.service;

import com.adopt.pet.entity.Pet;
import com.adopt.pet.enums.*;
import com.adopt.pet.exceptions.IdCannotBeNullException;
import com.adopt.pet.exceptions.PetByIdNotFoundException;
import com.adopt.pet.exceptions.PetCannotBeNullException;
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
    public static final SpeciesEnum TYPE_PET = SpeciesEnum.DOG;
    public static final GenderEnum GENDER = GenderEnum.MALE;
    public static final SizeEnum SIZE_ENUM = SizeEnum.PEQUENO_PORTE;
    public static final SelectOptionEnum OPTION_DO_NOT_KNOW = SelectOptionEnum.DO_NOT_KNOW;
    public static final SelectOptionEnum OPTION_NO = SelectOptionEnum.NO;
    public static final SelectOptionEnum OPTION_YES = SelectOptionEnum.YES;
    public static final StatusEnum STATUS_ENUM = StatusEnum.AVAILABLE;
    public static final String PET_HISTORY = "Little dog found abandoned on the street.";
    public static final String PET_DIET = "Premier Naturals";
    public static final StatusEnum STATUS_ENUM_IN_PROCESS = StatusEnum.IN_PROCESS;

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
        pet.setSize(SIZE_ENUM);
        pet.setVaccinated(OPTION_DO_NOT_KNOW);
        pet.setMicrochip(OPTION_NO);
        pet.setCastrated(OPTION_NO);
        pet.setSociality(OPTION_YES);
        pet.setNeedsSpeciality(OPTION_NO);
        pet.setExperienceAdopt(OPTION_NO);
        pet.setStatus(STATUS_ENUM);
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
    public void createNewPet(){
        Mockito.when(repository.save(getPet())).thenReturn(pet);
        service.createNewPet(pet);
        Assert.assertEquals(pet, getPet());
    }

    @Test(expected = PetCannotBeNullException.class)
    public void petNotNull(){
        service.createNewPet(null);
    }

    @Test
    public void findPetById(){
        Mockito.when(repository.findById((long) ID)).thenReturn(Optional.of(pet));
        Optional<Pet> findByIdPet = service.findPetById(pet.getId());
        Assert.assertTrue(findByIdPet.isPresent());
    }

    @Test(expected = PetByIdNotFoundException.class)
    public void idPetNotFound(){
        service.findPetById((long) 255);
    }

    @Test(expected = IdCannotBeNullException.class)
    public void findIdPetNull(){
        service.findPetById(null);
    }

    @Test
    public void updateDataPet(){
        petIsPresent();
        pet.setStatus(STATUS_ENUM_IN_PROCESS);
        service.updatePetData(pet, pet.getId());
        Assert.assertEquals(STATUS_ENUM_IN_PROCESS, pet.getStatus());
    }

    @Test(expected = PetByIdNotFoundException.class)
    public void updateErrorIdNotFound(){
        petIsPresent();
        pet.setStatus(STATUS_ENUM_IN_PROCESS);
        service.updatePetData(pet, (long) 255);
    }

    @Test(expected = IdCannotBeNullException.class)
    public void updatePetIdNull(){
        service.updatePetData(getPet(), null);
    }

    @Test
    public void deletePet(){
        boolean deleteOperation = service.deletePet(pet.getId());
        Assert.assertTrue(deleteOperation);
    }

    @Test(expected = IdCannotBeNullException.class)
    public void idPetNullDelete(){
        service.deletePet(null);
    }
}


