package com.adopt.pet.service;

import com.adopt.pet.entity.Address;
import com.adopt.pet.exceptions.AddressByIdNotFoundException;
import com.adopt.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository repository;

    public boolean createNewAddress(Address address){
        repository.save(address);
        return true;
    }

    public Optional<Address> findAddressById(Long id){
        Optional<Address> addressIn = repository.findById(id);
        validateAddressIsPresent(addressIn);
        return addressIn;
    }

    public Address updateAddressData(Address address, Long id){
        Optional<Address> addressIn = repository.findById(id);
        validateAddressIsPresent(addressIn);
        repository.save(address);
        return address;
    }

    public boolean deleteAddress(Long id){
        repository.deleteById(id);
        return true;
    }

    private void validateAddressIsPresent(Optional<Address> address) {
        if (!address.isPresent()){
            throw new AddressByIdNotFoundException("Address id not found.");
        }
    }

}
