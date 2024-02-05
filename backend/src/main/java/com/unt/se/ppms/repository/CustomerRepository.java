package com.unt.se.ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unt.se.ppms.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
