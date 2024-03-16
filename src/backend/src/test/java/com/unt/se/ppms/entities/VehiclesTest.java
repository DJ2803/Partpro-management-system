package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class VehiclesTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Vehicles#setColor(String)}
     *   <li>{@link Vehicles#setCustomer(Customer)}
     *   <li>{@link Vehicles#setLicenseplate(String)}
     *   <li>{@link Vehicles#setMileage(float)}
     *   <li>{@link Vehicles#setVehicleId(long)}
     *   <li>{@link Vehicles#setVehicleIdNumber(String)}
     *   <li>{@link Vehicles#setVehicleMaker(String)}
     *   <li>{@link Vehicles#setVehicleModel(String)}
     *   <li>{@link Vehicles#setVehicleType(String)}
     *   <li>{@link Vehicles#setVehicleUsage(String)}
     *   <li>{@link Vehicles#setVehicleYear(long)}
     *   <li>{@link Vehicles#getColor()}
     *   <li>{@link Vehicles#getCustomer()}
     *   <li>{@link Vehicles#getLicenseplate()}
     *   <li>{@link Vehicles#getMileage()}
     *   <li>{@link Vehicles#getVehicleId()}
     *   <li>{@link Vehicles#getVehicleIdNumber()}
     *   <li>{@link Vehicles#getVehicleMaker()}
     *   <li>{@link Vehicles#getVehicleModel()}
     *   <li>{@link Vehicles#getVehicleType()}
     *   <li>{@link Vehicles#getVehicleUsage()}
     *   <li>{@link Vehicles#getVehicleYear()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        Vehicles vehicles = new Vehicles();

        // Act
        vehicles.setColor("Color");
        User user = new User();
        user.setCustomer(new Customer());
        user.setEmailId("42");
        user.setEmployee(new Employee());
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setMobileNumber(1L);
        user.setOtp(new OneTimePasscode());
        user.setPassword("iloveyou");
        user.setTypeOfUser("Type Of User");
        user.setUserId(1);
        user.setUserName("janedoe");
        user.setZipcode(1L);
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setEmailId("42");
        customer.setFullName("Dr Jane Doe");
        customer.setGender("Gender");
        customer.setMobileNumber(1L);
        customer.setOnlineSales(new ArrayList<>());
        customer.setPassword("iloveyou");
        customer.setUser(user);
        customer.setUsername("janedoe");
        customer.setVehicles(new ArrayList<>());
        customer.setZipcode(1L);
        User user2 = new User();
        user2.setCustomer(new Customer());
        user2.setEmailId("42");
        user2.setEmployee(new Employee());
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setLastName("Doe");
        user2.setMobileNumber(1L);
        user2.setOtp(new OneTimePasscode());
        user2.setPassword("iloveyou");
        user2.setTypeOfUser("Type Of User");
        user2.setUserId(1);
        user2.setUserName("janedoe");
        user2.setZipcode(1L);
        Employee employee = new Employee();
        employee.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee.setDesignation("Designation");
        employee.setEmailId("42");
        employee.setEmployeeId(1);
        employee.setEmployeeName("Employee Name");
        employee.setEmployeeType("Employee Type");
        employee.setGender("Gender");
        employee.setLocations(new HashSet<>());
        employee.setMobileNumber(1L);
        employee.setOnlineSales(new ArrayList<>());
        employee.setPassword("iloveyou");
        employee.setSalary(1L);
        employee.setUser(user2);
        employee.setUserName("janedoe");
        User user3 = new User();
        user3.setCustomer(new Customer());
        user3.setEmailId("42");
        user3.setEmployee(new Employee());
        user3.setFirstName("Jane");
        user3.setGender("Gender");
        user3.setLastName("Doe");
        user3.setMobileNumber(1L);
        user3.setOtp(new OneTimePasscode());
        user3.setPassword("iloveyou");
        user3.setTypeOfUser("Type Of User");
        user3.setUserId(1);
        user3.setUserName("janedoe");
        user3.setZipcode(1L);
        OneTimePasscode otp = new OneTimePasscode();
        otp.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp.setId(1);
        otp.setOtp(1L);
        otp.setUser(user3);
        User user4 = new User();
        user4.setCustomer(customer);
        user4.setEmailId("42");
        user4.setEmployee(employee);
        user4.setFirstName("Jane");
        user4.setGender("Gender");
        user4.setLastName("Doe");
        user4.setMobileNumber(1L);
        user4.setOtp(otp);
        user4.setPassword("iloveyou");
        user4.setTypeOfUser("Type Of User");
        user4.setUserId(1);
        user4.setUserName("janedoe");
        user4.setZipcode(1L);
        Customer customer2 = new Customer();
        customer2.setCustomerId(1);
        customer2.setEmailId("42");
        customer2.setFullName("Dr Jane Doe");
        customer2.setGender("Gender");
        customer2.setMobileNumber(1L);
        customer2.setOnlineSales(new ArrayList<>());
        customer2.setPassword("iloveyou");
        customer2.setUser(user4);
        customer2.setUsername("janedoe");
        customer2.setVehicles(new ArrayList<>());
        customer2.setZipcode(1L);
        vehicles.setCustomer(customer2);
        vehicles.setLicenseplate("Licenseplate");
        vehicles.setMileage(10.0f);
        vehicles.setVehicleId(1L);
        vehicles.setVehicleIdNumber("42");
        vehicles.setVehicleMaker("Vehicle Maker");
        vehicles.setVehicleModel("Vehicle Model");
        vehicles.setVehicleType("Vehicle Type");
        vehicles.setVehicleUsage("Vehicle Usage");
        vehicles.setVehicleYear(1L);
        String actualColor = vehicles.getColor();
        Customer actualCustomer = vehicles.getCustomer();
        String actualLicenseplate = vehicles.getLicenseplate();
        float actualMileage = vehicles.getMileage();
        long actualVehicleId = vehicles.getVehicleId();
        String actualVehicleIdNumber = vehicles.getVehicleIdNumber();
        String actualVehicleMaker = vehicles.getVehicleMaker();
        String actualVehicleModel = vehicles.getVehicleModel();
        String actualVehicleType = vehicles.getVehicleType();
        String actualVehicleUsage = vehicles.getVehicleUsage();

        // Assert that nothing has changed
        assertEquals("42", actualVehicleIdNumber);
        assertEquals("Color", actualColor);
        assertEquals("Licenseplate", actualLicenseplate);
        assertEquals("Vehicle Maker", actualVehicleMaker);
        assertEquals("Vehicle Model", actualVehicleModel);
        assertEquals("Vehicle Type", actualVehicleType);
        assertEquals("Vehicle Usage", actualVehicleUsage);
        assertEquals(10.0f, actualMileage);
        assertEquals(1L, actualVehicleId);
        assertEquals(1L, vehicles.getVehicleYear());
        assertSame(customer2, actualCustomer);
    }
}
