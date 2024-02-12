package com.unt.se.ppms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unt.se.ppms.entities.Customer;
import com.unt.se.ppms.exceptions.CustomerNotFoundException;
import com.unt.se.ppms.repository.CustomerRepository;
import com.unt.se.ppms.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String updateCustomer(Customer customer) throws CustomerNotFoundException {
		try{
			customerRepository.save(customer);
			return "Customer updated successfully";
		}catch(Exception e) {
			throw new CustomerNotFoundException("Customer Invalid");
		}
		
	}

}
