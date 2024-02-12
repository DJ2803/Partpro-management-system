package com.unt.se.ppms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unt.se.ppms.entities.Customer;
import com.unt.se.ppms.exceptions.CustomerNotFoundException;
import com.unt.se.ppms.service.CustomerService;

@RestController
@RequestMapping("/ppms/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(Customer customer) throws CustomerNotFoundException{
		try {
			String str = customerService.updateCustomer(customer);
			return new ResponseEntity<>(str, HttpStatus.OK);
		}catch(CustomerNotFoundException e) {
			throw new CustomerNotFoundException(e.getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
