package com.adopt.pet.repository;

import com.adopt.pet.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Address, Long> {

}
