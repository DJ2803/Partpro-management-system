package com.unt.se.ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unt.se.ppms.entities.OneTimePasscode;

@Repository
public interface OneTimePasscodeRepository extends JpaRepository<OneTimePasscode, Integer> {

}
