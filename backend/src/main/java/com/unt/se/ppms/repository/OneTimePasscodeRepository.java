package com.unt.se.ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unt.se.ppms.entities.OneTimePasscode;

public interface OneTimePasscodeRepository extends JpaRepository<OneTimePasscode, Integer> {

}
