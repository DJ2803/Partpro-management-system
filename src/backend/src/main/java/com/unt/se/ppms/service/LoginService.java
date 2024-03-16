package com.unt.se.ppms.service;

import com.unt.se.ppms.dto.UserData;
import com.unt.se.ppms.entities.OneTimePasscode;
import com.unt.se.ppms.entities.User;
import com.unt.se.ppms.exceptions.InvalidLoginCredentialsException;
import com.unt.se.ppms.exceptions.OtpInvalidException;
import com.unt.se.ppms.exceptions.UserEmailIdAlreadyExistsException;
import com.unt.se.ppms.exceptions.UserNameAlreadyExistsException;
import com.unt.se.ppms.exceptions.UserNotFoundException;

public interface LoginService {

	public String signup(User user) throws UserNameAlreadyExistsException, UserEmailIdAlreadyExistsException;
	
	public UserData loginUserFirstStep(String username, String password) throws InvalidLoginCredentialsException,UserNotFoundException;
	
	public String loginUserSecondStep(int id, long otp) throws OtpInvalidException, UserNotFoundException;
	
	public String changePassword(String username, String newPassword) throws UserNotFoundException;
	
	public User getUserById(int id) throws UserNotFoundException;
	
	public User getUserByUsername(String username) throws UserNameAlreadyExistsException ;
	
	public User getUserByEmailId(String emailId) throws UserEmailIdAlreadyExistsException;
	
	public OneTimePasscode generateAndSaveOtp(int id) throws UserNotFoundException;
	
	public long getOtpById(int id) throws UserNotFoundException;
	
	public void sendOtpEmail(String recipientEmail, long otp, int userId);
	
}
