package com.unt.se.ppms.exceptions;

public class UserEmailIdAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	public UserEmailIdAlreadyExistsException(String errorMessage) {
	
		super(errorMessage);
	}
	@Override
	public String toString() {
		return "UserEmailIdAlreadyExistsException" + super.getMessage();
	}
	
}
