package com.unt.se.ppms.service;

import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.exceptions.EmployeeNotFoundException;

public interface EmployeeService {
	
	public String updateEmployee(Employee employee) throws EmployeeNotFoundException;

}
