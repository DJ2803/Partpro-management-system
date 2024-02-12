package com.unt.se.ppms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.exceptions.EmployeeNotFoundException;
import com.unt.se.ppms.repository.EmployeeRepository;
import com.unt.se.ppms.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public String updateEmployee(Employee employee) throws EmployeeNotFoundException {
		try {
			employeeRepository.save(employee);
			return "Employee updated successfully";
		}catch(Exception e) {
			throw new EmployeeNotFoundException("Employee Invalid");
		}
	}

}
