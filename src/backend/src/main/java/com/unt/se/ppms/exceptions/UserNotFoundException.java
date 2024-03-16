package com.unt.se.ppms.exceptions;

public class UserNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public  UserNotFoundException(String errorMessage) {
		
		super(errorMessage);
	}
	@Override
	public String toString() {
		return " UserNotFoundException " + super.getMessage();
	}

}
