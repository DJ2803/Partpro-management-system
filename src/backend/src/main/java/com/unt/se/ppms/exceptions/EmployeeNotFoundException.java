package com.unt.se.ppms.exceptions;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	public  EmployeeNotFoundException(String errorMessage) {
		
		super(errorMessage);
	}
	@Override
	public String toString() {
		return " EmployeeNotFoundException " + super.getMessage();
	}

	
}
