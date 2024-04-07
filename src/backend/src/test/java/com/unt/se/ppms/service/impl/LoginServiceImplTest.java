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
    void testSignup() throws UserNameAlreadyExistsException, UserEmailIdAlreadyExistsException {
        User user = new User();
        user.setUserName("username");
        user.setEmailId("email@example.com");
        when(loginRepository.existsByUserName(user.getUserName())).thenReturn(false);
        when(loginRepository.existsByEmailId(user.getEmailId())).thenReturn(false);
        when(loginRepository.save(user)).thenReturn(user);
        when(otpRepository.save(any(OneTimePasscode.class))).thenReturn(new OneTimePasscode());
        assertEquals("User added successfully", loginService.signup(user));
    }

    @Test
    void testSignup_UserNameAlreadyExists() {
        User user = new User();
        user.setUserName("existingUsername");
        when(loginRepository.existsByUserName(user.getUserName())).thenReturn(true);
        assertThrows(UserNameAlreadyExistsException.class, () -> loginService.signup(user));
    }

    @Test
    void testSignup_UserEmailIdAlreadyExists() {
        User user = new User();
        user.setEmailId("existingEmail@example.com");
        when(loginRepository.existsByUserName(user.getUserName())).thenReturn(false);
        when(loginRepository.existsByEmailId(user.getEmailId())).thenReturn(true);
        assertThrows(UserEmailIdAlreadyExistsException.class, () -> loginService.signup(user));
    }

    @Test
    void testLoginUserFirstStep() throws InvalidLoginCredentialsException, UserNotFoundException {
        User user = new User();
        user.setUserName("username");
        user.setPassword("password");
        Optional<User> optionalUser = Optional.of(user);
        when(loginRepository.findByUserName(user.getUserName())).thenReturn(optionalUser);
        UserData userData = loginService.loginUserFirstStep(user.getUserName(), user.getPassword());
        assertEquals("Enter OTP generated", userData.getMessage());
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
    void testLoginUserSecondStep() throws OtpInvalidException, UserNotFoundException {
        OneTimePasscode otp = new OneTimePasscode();
        otp.setOtp(1234);
        when(otpRepository.findById(1)).thenReturn(Optional.of(otp));
        when(otpRepository.save(any(OneTimePasscode.class))).thenReturn(otp);
        User user = new User();
        user.setUserId(1);
        user.setTypeOfUser("customer");
        when(loginRepository.findById(1)).thenReturn(Optional.of(user));
        assertEquals("customer Login successful", loginService.loginUserSecondStep(1, 1234));
    }

    @Test
    void testLoginUserSecondStep_OtpInvalid() {
        OneTimePasscode otp = new OneTimePasscode();
        otp.setOtp(4321);
        when(otpRepository.findById(1)).thenReturn(Optional.of(otp));
        assertThrows(OtpInvalidException.class, () -> loginService.loginUserSecondStep(1, 1234));
    }

    @Test
    void testChangePassword() throws UserNotFoundException {
        User user = new User();
        user.setUserName("username");
        user.setPassword("password");
        user.setTypeOfUser("customer");
        when(loginRepository.findByUserName(user.getUserName())).thenReturn(Optional.of(user));
        assertEquals("Password changed successfully", loginService.changePassword(user.getUserName(), "newPassword"));
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
    void testGenerateAndSaveOtp() throws UserNotFoundException {
        User user = new User();
        user.setUserId(1);
        when(loginRepository.findById(1)).thenReturn(Optional.of(user));
        when(otpRepository.save(any(OneTimePasscode.class))).thenReturn(new OneTimePasscode());
        assertNotNull(loginService.generateAndSaveOtp(1));
    }

    @Test
    void testGenerateAndSaveOtp_UserNotFoundException() {
        when(loginRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> loginService.generateAndSaveOtp(1));
    }

    @Test
    void testGetOtpById() throws UserNotFoundException {
        OneTimePasscode otp = new OneTimePasscode();
        otp.setOtp(1234);
        when(otpRepository.findById(1)).thenReturn(Optional.of(otp));
        assertEquals(1234, loginService.getOtpById(1));
    }

    @Test
    void testGetOtpById_UserNotFoundException() {
        when(otpRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> loginService.getOtpById(1));
    }


}