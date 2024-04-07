package com.unt.se.ppms.exceptions;

public class ProductNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	public  ProductNotFoundException(String errorMessage) {
		
		super(errorMessage);
	}
	@Override
	public String toString() {
		return " ProductNotFoundException " + super.getMessage();
	}

}
