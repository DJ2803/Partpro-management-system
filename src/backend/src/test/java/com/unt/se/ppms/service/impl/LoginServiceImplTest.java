package com.unt.se.ppms.service.impl;

import com.unt.se.ppms.dto.UserData;
import com.unt.se.ppms.entities.*;
import com.unt.se.ppms.exceptions.*;
import com.unt.se.ppms.repository.*;
import com.unt.se.ppms.repository.OneTimePasscodeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginServiceImplTest {

    @Mock
    private LoginRepository loginRepository;

    @Mock
    private OneTimePasscodeRepository otpRepository;

    @InjectMocks
    private LoginServiceImpl loginService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

  

    @Test
    void testSignup_UserNameAlreadyExists() {
        User user = new User();
        user.setUserName("existingUsername");
        when(loginRepository.existsByUserName(user.getUserName())).thenReturn(true);
    }

    @Test
    void testSignup_UserEmailIdAlreadyExists() {
        User user = new User();
        user.setEmailId("existingEmail@example.com");
        when(loginRepository.existsByUserName(user.getUserName())).thenReturn(false);
        when(loginRepository.existsByEmailId(user.getEmailId())).thenReturn(true);
      }


    @Test
    void testLoginUserFirstStep_InvalidCredentials() {
        User user = new User();
        user.setUserName("username");
        user.setPassword("password");
        when(loginRepository.findByUserName(user.getUserName())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> loginService.loginUserFirstStep(user.getUserName(), user.getPassword()));
    }

    

    @Test
    void testLoginUserSecondStep_OtpInvalid() {
        OneTimePasscode otp = new OneTimePasscode();
        otp.setOtp(4321);
        when(otpRepository.findById(1)).thenReturn(Optional.of(otp));
    }

   

    @Test
    void testChangePassword_UserNotFoundException() {
        User user = new User();
        user.setUserName("nonExistingUser");
        when(loginRepository.findByUserName(user.getUserName())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> loginService.changePassword(user.getUserName(), "newPassword"));
    }

    @Test
    void testGetUserById() throws UserNotFoundException {
        User user = new User();
        user.setUserId(1);
        when(loginRepository.findById(1)).thenReturn(Optional.of(user));
        assertEquals(user, loginService.getUserById(1));
    }

    @Test
    void testGetUserById_UserNotFoundException() {
        when(loginRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> loginService.getUserById(1));
    }

    @Test
    void testGetUserByUsername() throws UserNameAlreadyExistsException {
        User user = new User();
        user.setUserName("username");
        when(loginRepository.findByUserName(user.getUserName())).thenReturn(Optional.of(user));
        assertEquals(user, loginService.getUserByUsername(user.getUserName()));
    }

    @Test
    void testGetUserByUsername_UserNameAlreadyExistsException() {
        User user = new User();
        user.setUserName("existingUsername");
        when(loginRepository.findByUserName(user.getUserName())).thenReturn(Optional.empty());
        assertThrows(UserNameAlreadyExistsException.class, () -> loginService.getUserByUsername(user.getUserName()));
    }

    

    @Test
    void testGenerateAndSaveOtp_UserNotFoundException() {
        when(loginRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> loginService.generateAndSaveOtp(1));
    }

    

    @Test
    void testGetOtpById_UserNotFoundException() {
        when(otpRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> loginService.getOtpById(1));
    }


}