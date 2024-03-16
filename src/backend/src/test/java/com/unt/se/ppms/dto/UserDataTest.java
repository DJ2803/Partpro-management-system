package com.unt.se.ppms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserDataTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserData#setEmailId(String)}
     *   <li>{@link UserData#setFirstName(String)}
     *   <li>{@link UserData#setLastName(String)}
     *   <li>{@link UserData#setMessage(String)}
     *   <li>{@link UserData#setMobileNumber(long)}
     *   <li>{@link UserData#setPassword(String)}
     *   <li>{@link UserData#setTypeOfUser(String)}
     *   <li>{@link UserData#setUserId(int)}
     *   <li>{@link UserData#setUserName(String)}
     *   <li>{@link UserData#setZipcode(long)}
     *   <li>{@link UserData#getEmailId()}
     *   <li>{@link UserData#getFirstName()}
     *   <li>{@link UserData#getLastName()}
     *   <li>{@link UserData#getMessage()}
     *   <li>{@link UserData#getMobileNumber()}
     *   <li>{@link UserData#getPassword()}
     *   <li>{@link UserData#getTypeOfUser()}
     *   <li>{@link UserData#getUserId()}
     *   <li>{@link UserData#getUserName()}
     *   <li>{@link UserData#getZipcode()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        UserData userData = new UserData();

        // Act
        userData.setEmailId("42");
        userData.setFirstName("Jane");
        userData.setLastName("Doe");
        userData.setMessage("Not all who wander are lost");
        userData.setMobileNumber(1L);
        userData.setPassword("iloveyou");
        userData.setTypeOfUser("Type Of User");
        userData.setUserId(1);
        userData.setUserName("janedoe");
        userData.setZipcode(1L);
        String actualEmailId = userData.getEmailId();
        String actualFirstName = userData.getFirstName();
        String actualLastName = userData.getLastName();
        String actualMessage = userData.getMessage();
        long actualMobileNumber = userData.getMobileNumber();
        String actualPassword = userData.getPassword();
        String actualTypeOfUser = userData.getTypeOfUser();
        int actualUserId = userData.getUserId();
        String actualUserName = userData.getUserName();

        // Assert that nothing has changed
        assertEquals("42", actualEmailId);
        assertEquals("Doe", actualLastName);
        assertEquals("Jane", actualFirstName);
        assertEquals("Not all who wander are lost", actualMessage);
        assertEquals("Type Of User", actualTypeOfUser);
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualUserName);
        assertEquals(1, actualUserId);
        assertEquals(1L, actualMobileNumber);
        assertEquals(1L, userData.getZipcode());
    }
}
