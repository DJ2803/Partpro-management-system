package com.unt.se.ppms.service;

import com.unt.se.ppms.entities.Customer;
import com.unt.se.ppms.exceptions.CustomerNotFoundException;

public interface CustomerService {
	
	public String updateCustomer(Customer customer) throws CustomerNotFoundException;

}
