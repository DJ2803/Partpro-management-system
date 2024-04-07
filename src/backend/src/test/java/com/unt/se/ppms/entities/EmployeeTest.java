package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Employee.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class EmployeeTest {
    @Autowired
    private Employee employee;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Employee#Employee()}
     *   <li>{@link Employee#setDateOfHire(LocalDate)}
     *   <li>{@link Employee#setDesignation(String)}
     *   <li>{@link Employee#setEmailId(String)}
     *   <li>{@link Employee#setEmployeeId(int)}
     *   <li>{@link Employee#setEmployeeName(String)}
     *   <li>{@link Employee#setEmployeeType(String)}
     *   <li>{@link Employee#setGender(String)}
     *   <li>{@link Employee#setLocations(Set)}
     *   <li>{@link Employee#setMobileNumber(long)}
     *   <li>{@link Employee#setOnlineSales(List)}
     *   <li>{@link Employee#setPassword(String)}
     *   <li>{@link Employee#setSalary(long)}
     *   <li>{@link Employee#setUser(User)}
     *   <li>{@link Employee#setUserName(String)}
     *   <li>{@link Employee#toString()}
     *   <li>{@link Employee#getDateOfHire()}
     *   <li>{@link Employee#getDesignation()}
     *   <li>{@link Employee#getEmailId()}
     *   <li>{@link Employee#getEmployeeId()}
     *   <li>{@link Employee#getEmployeeName()}
     *   <li>{@link Employee#getEmployeeType()}
     *   <li>{@link Employee#getGender()}
     *   <li>{@link Employee#getLocations()}
     *   <li>{@link Employee#getMobileNumber()}
     *   <li>{@link Employee#getOnlineSales()}
     *   <li>{@link Employee#getPassword()}
     *   <li>{@link Employee#getSalary()}
     *   <li>{@link Employee#getUser()}
     *   <li>{@link Employee#getUserName()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Employee actualEmployee = new Employee();
        LocalDate dateOfHire = LocalDate.of(1970, 1, 1);
        actualEmployee.setDateOfHire(dateOfHire);
        actualEmployee.setDesignation("Designation");
        actualEmployee.setEmailId("42");
        actualEmployee.setEmployeeId(1);
        actualEmployee.setEmployeeName("Employee Name");
        actualEmployee.setEmployeeType("Employee Type");
        actualEmployee.setGender("Gender");
        HashSet<Location> locations = new HashSet<>();
        actualEmployee.setLocations(locations);
        actualEmployee.setMobileNumber(1L);
        ArrayList<OnlineSales> onlineSales = new ArrayList<>();
        actualEmployee.setOnlineSales(onlineSales);
        actualEmployee.setPassword("iloveyou");
        actualEmployee.setSalary(1L);
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setEmailId("42");
        customer.setFullName("Dr Jane Doe");
        customer.setGender("Gender");
        customer.setMobileNumber(1L);
        customer.setOnlineSales(new ArrayList<>());
        customer.setPassword("iloveyou");
        customer.setUser(new User());
        customer.setUsername("janedoe");
        customer.setVehicles(new ArrayList<>());
        customer.setZipcode(1L);
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
        employee.setUser(new User());
        employee.setUserName("janedoe");
        OneTimePasscode otp = new OneTimePasscode();
        otp.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp.setId(1);
        otp.setOtp(1L);
        otp.setUser(new User());
        User user = new User();
        user.setCustomer(customer);
        user.setEmailId("42");
        user.setEmployee(employee);
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setMobileNumber(1L);
        user.setOtp(otp);
        user.setPassword("iloveyou");
        user.setTypeOfUser("Type Of User");
        user.setUserId(1);
        user.setUserName("janedoe");
        user.setZipcode(1L);
        Customer customer2 = new Customer();
        customer2.setCustomerId(1);
        customer2.setEmailId("42");
        customer2.setFullName("Dr Jane Doe");
        customer2.setGender("Gender");
        customer2.setMobileNumber(1L);
        customer2.setOnlineSales(new ArrayList<>());
        customer2.setPassword("iloveyou");
        customer2.setUser(user);
        customer2.setUsername("janedoe");
        customer2.setVehicles(new ArrayList<>());
        customer2.setZipcode(1L);
        Customer customer3 = new Customer();
        customer3.setCustomerId(1);
        customer3.setEmailId("42");
        customer3.setFullName("Dr Jane Doe");
        customer3.setGender("Gender");
        customer3.setMobileNumber(1L);
        customer3.setOnlineSales(new ArrayList<>());
        customer3.setPassword("iloveyou");
        customer3.setUser(new User());
        customer3.setUsername("janedoe");
        customer3.setVehicles(new ArrayList<>());
        customer3.setZipcode(1L);
        Employee employee2 = new Employee();
        employee2.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee2.setDesignation("Designation");
        employee2.setEmailId("42");
        employee2.setEmployeeId(1);
        employee2.setEmployeeName("Employee Name");
        employee2.setEmployeeType("Employee Type");
        employee2.setGender("Gender");
        employee2.setLocations(new HashSet<>());
        employee2.setMobileNumber(1L);
        employee2.setOnlineSales(new ArrayList<>());
        employee2.setPassword("iloveyou");
        employee2.setSalary(1L);
        employee2.setUser(new User());
        employee2.setUserName("janedoe");
        OneTimePasscode otp2 = new OneTimePasscode();
        otp2.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp2.setId(1);
        otp2.setOtp(1L);
        otp2.setUser(new User());
        User user2 = new User();
        user2.setCustomer(customer3);
        user2.setEmailId("42");
        user2.setEmployee(employee2);
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setLastName("Doe");
        user2.setMobileNumber(1L);
        user2.setOtp(otp2);
        user2.setPassword("iloveyou");
        user2.setTypeOfUser("Type Of User");
        user2.setUserId(1);
        user2.setUserName("janedoe");
        user2.setZipcode(1L);
        Employee employee3 = new Employee();
        employee3.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee3.setDesignation("Designation");
        employee3.setEmailId("42");
        employee3.setEmployeeId(1);
        employee3.setEmployeeName("Employee Name");
        employee3.setEmployeeType("Employee Type");
        employee3.setGender("Gender");
        employee3.setLocations(new HashSet<>());
        employee3.setMobileNumber(1L);
        employee3.setOnlineSales(new ArrayList<>());
        employee3.setPassword("iloveyou");
        employee3.setSalary(1L);
        employee3.setUser(user2);
        employee3.setUserName("janedoe");
        Customer customer4 = new Customer();
        customer4.setCustomerId(1);
        customer4.setEmailId("42");
        customer4.setFullName("Dr Jane Doe");
        customer4.setGender("Gender");
        customer4.setMobileNumber(1L);
        customer4.setOnlineSales(new ArrayList<>());
        customer4.setPassword("iloveyou");
        customer4.setUser(new User());
        customer4.setUsername("janedoe");
        customer4.setVehicles(new ArrayList<>());
        customer4.setZipcode(1L);
        Employee employee4 = new Employee();
        employee4.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee4.setDesignation("Designation");
        employee4.setEmailId("42");
        employee4.setEmployeeId(1);
        employee4.setEmployeeName("Employee Name");
        employee4.setEmployeeType("Employee Type");
        employee4.setGender("Gender");
        employee4.setLocations(new HashSet<>());
        employee4.setMobileNumber(1L);
        employee4.setOnlineSales(new ArrayList<>());
        employee4.setPassword("iloveyou");
        employee4.setSalary(1L);
        employee4.setUser(new User());
        employee4.setUserName("janedoe");
        OneTimePasscode otp3 = new OneTimePasscode();
        otp3.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp3.setId(1);
        otp3.setOtp(1L);
        otp3.setUser(new User());
        User user3 = new User();
        user3.setCustomer(customer4);
        user3.setEmailId("42");
        user3.setEmployee(employee4);
        user3.setFirstName("Jane");
        user3.setGender("Gender");
        user3.setLastName("Doe");
        user3.setMobileNumber(1L);
        user3.setOtp(otp3);
        user3.setPassword("iloveyou");
        user3.setTypeOfUser("Type Of User");
        user3.setUserId(1);
        user3.setUserName("janedoe");
        user3.setZipcode(1L);
        OneTimePasscode otp4 = new OneTimePasscode();
        otp4.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp4.setId(1);
        otp4.setOtp(1L);
        otp4.setUser(user3);
        User user4 = new User();
        user4.setCustomer(customer2);
        user4.setEmailId("42");
        user4.setEmployee(employee3);
        user4.setFirstName("Jane");
        user4.setGender("Gender");
        user4.setLastName("Doe");
        user4.setMobileNumber(1L);
        user4.setOtp(otp4);
        user4.setPassword("iloveyou");
        user4.setTypeOfUser("Type Of User");
        user4.setUserId(1);
        user4.setUserName("janedoe");
        user4.setZipcode(1L);
        actualEmployee.setUser(user4);
        actualEmployee.setUserName("janedoe");
        String actualToStringResult = actualEmployee.toString();
        LocalDate actualDateOfHire = actualEmployee.getDateOfHire();
        String actualDesignation = actualEmployee.getDesignation();
        String actualEmailId = actualEmployee.getEmailId();
        int actualEmployeeId = actualEmployee.getEmployeeId();
        String actualEmployeeName = actualEmployee.getEmployeeName();
        String actualEmployeeType = actualEmployee.getEmployeeType();
        String actualGender = actualEmployee.getGender();
        Set<Location> actualLocations = actualEmployee.getLocations();
        long actualMobileNumber = actualEmployee.getMobileNumber();
        List<OnlineSales> actualOnlineSales = actualEmployee.getOnlineSales();
        String actualPassword = actualEmployee.getPassword();
        long actualSalary = actualEmployee.getSalary();
        User actualUser = actualEmployee.getUser();

        // Assert that nothing has changed
        assertEquals("42", actualEmailId);
        assertEquals("Designation", actualDesignation);
        assertEquals("Employee Name", actualEmployeeName);
        assertEquals("Employee Type", actualEmployeeType);
        assertEquals("Employee [employeeId=1, employeeName=Employee Name, userName=janedoe, password=iloveyou, employeeType"
                + "=Employee Type, emailId=42, dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1,"
                + " designation=Designation, user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane,"
                + " lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User,"
                + " customer=Customer [customerId=1, username=janedoe, password=iloveyou, fullName=Dr Jane Doe, emailId=42,"
                + " + gender=Gender, mobileNumber=1, zipcode=1, user=User [userId=1, userName=janedoe, password=iloveyou,"
                + " firstName=Jane, lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type"
                + " Of User, customer=Customer [customerId=1, username=janedoe, password=iloveyou, fullName=Dr Jane Doe,"
                + " emailId=42, + gender=Gender, mobileNumber=1, zipcode=1, user=User [userId=0, userName=null, password=null,"
                + " firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0, zipcode=0, typeOfUser=null,"
                + " customer=null, employee=null, otp=null], vehicles=[], onlineSales=[]], employee=Employee [employeeId=1,"
                + " employeeName=Employee Name, userName=janedoe, password=iloveyou, employeeType=Employee Type, emailId=42,"
                + " dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1, designation=Designation, user=User"
                + " [userId=0, userName=null, password=null, firstName=null, lastName=null, emailId=null, gender=null,"
                + " mobileNumber=0, zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null], locations=[],"
                + " onlineSales=[]], otp=OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=0,"
                + " userName=null, password=null, firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0,"
                + " zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null]]], vehicles=[], onlineSales=[]],"
                + " employee=Employee [employeeId=1, employeeName=Employee Name, userName=janedoe, password=iloveyou,"
                + " employeeType=Employee Type, emailId=42, dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1,"
                + " designation=Designation, user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane,"
                + " lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User,"
                + " customer=Customer [customerId=1, username=janedoe, password=iloveyou, fullName=Dr Jane Doe, emailId=42,"
                + " + gender=Gender, mobileNumber=1, zipcode=1, user=User [userId=0, userName=null, password=null,"
                + " firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0, zipcode=0, typeOfUser=null,"
                + " customer=null, employee=null, otp=null], vehicles=[], onlineSales=[]], employee=Employee [employeeId=1,"
                + " employeeName=Employee Name, userName=janedoe, password=iloveyou, employeeType=Employee Type, emailId=42,"
                + " dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1, designation=Designation, user=User"
                + " [userId=0, userName=null, password=null, firstName=null, lastName=null, emailId=null, gender=null,"
                + " mobileNumber=0, zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null], locations=[],"
                + " onlineSales=[]], otp=OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=0,"
                + " userName=null, password=null, firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0,"
                + " zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null]]], locations=[], onlineSales=[]],"
                + " otp=OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=1, userName=janedoe,"
                + " password=iloveyou, firstName=Jane, lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1,"
                + " typeOfUser=Type Of User, customer=Customer [customerId=1, username=janedoe, password=iloveyou,"
                + " fullName=Dr Jane Doe, emailId=42, + gender=Gender, mobileNumber=1, zipcode=1, user=User [userId=0,"
                + " userName=null, password=null, firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0,"
                + " zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null], vehicles=[], onlineSales=[]],"
                + " employee=Employee [employeeId=1, employeeName=Employee Name, userName=janedoe, password=iloveyou,"
                + " employeeType=Employee Type, emailId=42, dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1,"
                + " designation=Designation, user=User [userId=0, userName=null, password=null, firstName=null, lastName=null,"
                + " emailId=null, gender=null, mobileNumber=0, zipcode=0, typeOfUser=null, customer=null, employee=null,"
                + " otp=null], locations=[], onlineSales=[]], otp=OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00,"
                + " user=User [userId=0, userName=null, password=null, firstName=null, lastName=null, emailId=null,"
                + " gender=null, mobileNumber=0, zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null]]]]],"
                + " locations=[], onlineSales=[]]", actualToStringResult);
        assertEquals("Gender", actualGender);
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualEmployee.getUserName());
        assertEquals(1, actualEmployeeId);
        assertEquals(1L, actualMobileNumber);
        assertEquals(1L, actualSalary);
        assertSame(user4, actualUser);
        assertSame(onlineSales, actualOnlineSales);
        assertSame(locations, actualLocations);
        assertSame(dateOfHire, actualDateOfHire);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Employee#Employee(int, String, String, String, String, User)}
     *   <li>{@link Employee#Employee()}
     *   <li>{@link Employee#setDateOfHire(LocalDate)}
     *   <li>{@link Employee#setDesignation(String)}
     *   <li>{@link Employee#setEmailId(String)}
     *   <li>{@link Employee#setEmployeeId(int)}
     *   <li>{@link Employee#setEmployeeName(String)}
     *   <li>{@link Employee#setEmployeeType(String)}
     *   <li>{@link Employee#setGender(String)}
     *   <li>{@link Employee#setLocations(Set)}
     *   <li>{@link Employee#setMobileNumber(long)}
     *   <li>{@link Employee#setOnlineSales(List)}
     *   <li>{@link Employee#setPassword(String)}
     *   <li>{@link Employee#setSalary(long)}
     *   <li>{@link Employee#setUser(User)}
     *   <li>{@link Employee#setUserName(String)}
     *   <li>{@link Employee#toString()}
     *   <li>{@link Employee#getDateOfHire()}
     *   <li>{@link Employee#getDesignation()}
     *   <li>{@link Employee#getEmailId()}
     *   <li>{@link Employee#getEmployeeId()}
     *   <li>{@link Employee#getEmployeeName()}
     *   <li>{@link Employee#getEmployeeType()}
     *   <li>{@link Employee#getGender()}
     *   <li>{@link Employee#getLocations()}
     *   <li>{@link Employee#getMobileNumber()}
     *   <li>{@link Employee#getOnlineSales()}
     *   <li>{@link Employee#getPassword()}
     *   <li>{@link Employee#getSalary()}
     *   <li>{@link Employee#getUser()}
     *   <li>{@link Employee#getUserName()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setEmailId("42");
        customer.setFullName("Dr Jane Doe");
        customer.setGender("Gender");
        customer.setMobileNumber(1L);
        customer.setOnlineSales(new ArrayList<>());
        customer.setPassword("iloveyou");
        customer.setUser(new User());
        customer.setUsername("janedoe");
        customer.setVehicles(new ArrayList<>());
        customer.setZipcode(1L);

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
        employee.setUser(new User());
        employee.setUserName("janedoe");

        OneTimePasscode otp = new OneTimePasscode();
        otp.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp.setId(1);
        otp.setOtp(1L);
        otp.setUser(new User());

        User user = new User();
        user.setCustomer(customer);
        user.setEmailId("42");
        user.setEmployee(employee);
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setMobileNumber(1L);
        user.setOtp(otp);
        user.setPassword("iloveyou");
        user.setTypeOfUser("Type Of User");
        user.setUserId(1);
        user.setUserName("janedoe");
        user.setZipcode(1L);

        Customer customer2 = new Customer();
        customer2.setCustomerId(1);
        customer2.setEmailId("42");
        customer2.setFullName("Dr Jane Doe");
        customer2.setGender("Gender");
        customer2.setMobileNumber(1L);
        ArrayList<OnlineSales> onlineSales = new ArrayList<>();
        customer2.setOnlineSales(onlineSales);
        customer2.setPassword("iloveyou");
        customer2.setUser(user);
        customer2.setUsername("janedoe");
        customer2.setVehicles(new ArrayList<>());
        customer2.setZipcode(1L);

        Customer customer3 = new Customer();
        customer3.setCustomerId(1);
        customer3.setEmailId("42");
        customer3.setFullName("Dr Jane Doe");
        customer3.setGender("Gender");
        customer3.setMobileNumber(1L);
        customer3.setOnlineSales(new ArrayList<>());
        customer3.setPassword("iloveyou");
        customer3.setUser(new User());
        customer3.setUsername("janedoe");
        customer3.setVehicles(new ArrayList<>());
        customer3.setZipcode(1L);

        Employee employee2 = new Employee();
        employee2.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee2.setDesignation("Designation");
        employee2.setEmailId("42");
        employee2.setEmployeeId(1);
        employee2.setEmployeeName("Employee Name");
        employee2.setEmployeeType("Employee Type");
        employee2.setGender("Gender");
        employee2.setLocations(new HashSet<>());
        employee2.setMobileNumber(1L);
        employee2.setOnlineSales(new ArrayList<>());
        employee2.setPassword("iloveyou");
        employee2.setSalary(1L);
        employee2.setUser(new User());
        employee2.setUserName("janedoe");

        OneTimePasscode otp2 = new OneTimePasscode();
        otp2.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp2.setId(1);
        otp2.setOtp(1L);
        otp2.setUser(new User());

        User user2 = new User();
        user2.setCustomer(customer3);
        user2.setEmailId("42");
        user2.setEmployee(employee2);
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setLastName("Doe");
        user2.setMobileNumber(1L);
        user2.setOtp(otp2);
        user2.setPassword("iloveyou");
        user2.setTypeOfUser("Type Of User");
        user2.setUserId(1);
        user2.setUserName("janedoe");
        user2.setZipcode(1L);

        Employee employee3 = new Employee();
        employee3.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee3.setDesignation("Designation");
        employee3.setEmailId("42");
        employee3.setEmployeeId(1);
        employee3.setEmployeeName("Employee Name");
        employee3.setEmployeeType("Employee Type");
        employee3.setGender("Gender");
        employee3.setLocations(new HashSet<>());
        employee3.setMobileNumber(1L);
        employee3.setOnlineSales(new ArrayList<>());
        employee3.setPassword("iloveyou");
        employee3.setSalary(1L);
        employee3.setUser(user2);
        employee3.setUserName("janedoe");

        Customer customer4 = new Customer();
        customer4.setCustomerId(1);
        customer4.setEmailId("42");
        customer4.setFullName("Dr Jane Doe");
        customer4.setGender("Gender");
        customer4.setMobileNumber(1L);
        customer4.setOnlineSales(new ArrayList<>());
        customer4.setPassword("iloveyou");
        customer4.setUser(new User());
        customer4.setUsername("janedoe");
        customer4.setVehicles(new ArrayList<>());
        customer4.setZipcode(1L);

        Employee employee4 = new Employee();
        employee4.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee4.setDesignation("Designation");
        employee4.setEmailId("42");
        employee4.setEmployeeId(1);
        employee4.setEmployeeName("Employee Name");
        employee4.setEmployeeType("Employee Type");
        employee4.setGender("Gender");
        employee4.setLocations(new HashSet<>());
        employee4.setMobileNumber(1L);
        employee4.setOnlineSales(new ArrayList<>());
        employee4.setPassword("iloveyou");
        employee4.setSalary(1L);
        employee4.setUser(new User());
        employee4.setUserName("janedoe");

        OneTimePasscode otp3 = new OneTimePasscode();
        otp3.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp3.setId(1);
        otp3.setOtp(1L);
        otp3.setUser(new User());

        User user3 = new User();
        user3.setCustomer(customer4);
        user3.setEmailId("42");
        user3.setEmployee(employee4);
        user3.setFirstName("Jane");
        user3.setGender("Gender");
        user3.setLastName("Doe");
        user3.setMobileNumber(1L);
        user3.setOtp(otp3);
        user3.setPassword("iloveyou");
        user3.setTypeOfUser("Type Of User");
        user3.setUserId(1);
        user3.setUserName("janedoe");
        user3.setZipcode(1L);

        OneTimePasscode otp4 = new OneTimePasscode();
        otp4.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp4.setId(1);
        otp4.setOtp(1L);
        otp4.setUser(user3);

        User user4 = new User();
        user4.setCustomer(customer2);
        user4.setEmailId("42");
        user4.setEmployee(employee3);
        user4.setFirstName("Jane");
        user4.setGender("Gender");
        user4.setLastName("Doe");
        user4.setMobileNumber(1L);
        user4.setOtp(otp4);
        user4.setPassword("iloveyou");
        user4.setTypeOfUser("Type Of User");
        user4.setUserId(1);
        user4.setUserName("janedoe");
        user4.setZipcode(1L);

        // Act
        Employee actualEmployee = new Employee(1, "Employee Name", "iloveyou", "42", "janedoe", null, 0, user4);
        LocalDate dateOfHire = LocalDate.of(1970, 1, 1);
        actualEmployee.setDateOfHire(dateOfHire);
        actualEmployee.setDesignation("Designation");
        actualEmployee.setEmailId("42");
        actualEmployee.setEmployeeId(1);
        actualEmployee.setEmployeeName("Employee Name");
        actualEmployee.setEmployeeType("Employee Type");
        actualEmployee.setGender("Gender");
        HashSet<Location> locations = new HashSet<>();
        actualEmployee.setLocations(locations);
        actualEmployee.setMobileNumber(1L);
        ArrayList<OnlineSales> onlineSales2 = new ArrayList<>();
        actualEmployee.setOnlineSales(onlineSales2);
        actualEmployee.setPassword("iloveyou");
        actualEmployee.setSalary(1L);
        Customer customer5 = new Customer();
        customer5.setCustomerId(1);
        customer5.setEmailId("42");
        customer5.setFullName("Dr Jane Doe");
        customer5.setGender("Gender");
        customer5.setMobileNumber(1L);
        customer5.setOnlineSales(new ArrayList<>());
        customer5.setPassword("iloveyou");
        customer5.setUser(new User());
        customer5.setUsername("janedoe");
        customer5.setVehicles(new ArrayList<>());
        customer5.setZipcode(1L);
        Employee employee5 = new Employee();
        employee5.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee5.setDesignation("Designation");
        employee5.setEmailId("42");
        employee5.setEmployeeId(1);
        employee5.setEmployeeName("Employee Name");
        employee5.setEmployeeType("Employee Type");
        employee5.setGender("Gender");
        employee5.setLocations(new HashSet<>());
        employee5.setMobileNumber(1L);
        employee5.setOnlineSales(new ArrayList<>());
        employee5.setPassword("iloveyou");
        employee5.setSalary(1L);
        employee5.setUser(new User());
        employee5.setUserName("janedoe");
        OneTimePasscode otp5 = new OneTimePasscode();
        otp5.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp5.setId(1);
        otp5.setOtp(1L);
        otp5.setUser(new User());
        User user5 = new User();
        user5.setCustomer(customer5);
        user5.setEmailId("42");
        user5.setEmployee(employee5);
        user5.setFirstName("Jane");
        user5.setGender("Gender");
        user5.setLastName("Doe");
        user5.setMobileNumber(1L);
        user5.setOtp(otp5);
        user5.setPassword("iloveyou");
        user5.setTypeOfUser("Type Of User");
        user5.setUserId(1);
        user5.setUserName("janedoe");
        user5.setZipcode(1L);
        Customer customer6 = new Customer();
        customer6.setCustomerId(1);
        customer6.setEmailId("42");
        customer6.setFullName("Dr Jane Doe");
        customer6.setGender("Gender");
        customer6.setMobileNumber(1L);
        customer6.setOnlineSales(new ArrayList<>());
        customer6.setPassword("iloveyou");
        customer6.setUser(user5);
        customer6.setUsername("janedoe");
        customer6.setVehicles(new ArrayList<>());
        customer6.setZipcode(1L);
        Customer customer7 = new Customer();
        customer7.setCustomerId(1);
        customer7.setEmailId("42");
        customer7.setFullName("Dr Jane Doe");
        customer7.setGender("Gender");
        customer7.setMobileNumber(1L);
        customer7.setOnlineSales(new ArrayList<>());
        customer7.setPassword("iloveyou");
        customer7.setUser(new User());
        customer7.setUsername("janedoe");
        customer7.setVehicles(new ArrayList<>());
        customer7.setZipcode(1L);
        Employee employee6 = new Employee();
        employee6.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee6.setDesignation("Designation");
        employee6.setEmailId("42");
        employee6.setEmployeeId(1);
        employee6.setEmployeeName("Employee Name");
        employee6.setEmployeeType("Employee Type");
        employee6.setGender("Gender");
        employee6.setLocations(new HashSet<>());
        employee6.setMobileNumber(1L);
        employee6.setOnlineSales(new ArrayList<>());
        employee6.setPassword("iloveyou");
        employee6.setSalary(1L);
        employee6.setUser(new User());
        employee6.setUserName("janedoe");
        OneTimePasscode otp6 = new OneTimePasscode();
        otp6.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp6.setId(1);
        otp6.setOtp(1L);
        otp6.setUser(new User());
        User user6 = new User();
        user6.setCustomer(customer7);
        user6.setEmailId("42");
        user6.setEmployee(employee6);
        user6.setFirstName("Jane");
        user6.setGender("Gender");
        user6.setLastName("Doe");
        user6.setMobileNumber(1L);
        user6.setOtp(otp6);
        user6.setPassword("iloveyou");
        user6.setTypeOfUser("Type Of User");
        user6.setUserId(1);
        user6.setUserName("janedoe");
        user6.setZipcode(1L);
        Employee employee7 = new Employee();
        employee7.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee7.setDesignation("Designation");
        employee7.setEmailId("42");
        employee7.setEmployeeId(1);
        employee7.setEmployeeName("Employee Name");
        employee7.setEmployeeType("Employee Type");
        employee7.setGender("Gender");
        employee7.setLocations(new HashSet<>());
        employee7.setMobileNumber(1L);
        employee7.setOnlineSales(new ArrayList<>());
        employee7.setPassword("iloveyou");
        employee7.setSalary(1L);
        employee7.setUser(user6);
        employee7.setUserName("janedoe");
        Customer customer8 = new Customer();
        customer8.setCustomerId(1);
        customer8.setEmailId("42");
        customer8.setFullName("Dr Jane Doe");
        customer8.setGender("Gender");
        customer8.setMobileNumber(1L);
        customer8.setOnlineSales(new ArrayList<>());
        customer8.setPassword("iloveyou");
        customer8.setUser(new User());
        customer8.setUsername("janedoe");
        customer8.setVehicles(new ArrayList<>());
        customer8.setZipcode(1L);
        Employee employee8 = new Employee();
        employee8.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee8.setDesignation("Designation");
        employee8.setEmailId("42");
        employee8.setEmployeeId(1);
        employee8.setEmployeeName("Employee Name");
        employee8.setEmployeeType("Employee Type");
        employee8.setGender("Gender");
        employee8.setLocations(new HashSet<>());
        employee8.setMobileNumber(1L);
        employee8.setOnlineSales(new ArrayList<>());
        employee8.setPassword("iloveyou");
        employee8.setSalary(1L);
        employee8.setUser(new User());
        employee8.setUserName("janedoe");
        OneTimePasscode otp7 = new OneTimePasscode();
        otp7.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp7.setId(1);
        otp7.setOtp(1L);
        otp7.setUser(new User());
        User user7 = new User();
        user7.setCustomer(customer8);
        user7.setEmailId("42");
        user7.setEmployee(employee8);
        user7.setFirstName("Jane");
        user7.setGender("Gender");
        user7.setLastName("Doe");
        user7.setMobileNumber(1L);
        user7.setOtp(otp7);
        user7.setPassword("iloveyou");
        user7.setTypeOfUser("Type Of User");
        user7.setUserId(1);
        user7.setUserName("janedoe");
        user7.setZipcode(1L);
        OneTimePasscode otp8 = new OneTimePasscode();
        otp8.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp8.setId(1);
        otp8.setOtp(1L);
        otp8.setUser(user7);
        User user8 = new User();
        user8.setCustomer(customer6);
        user8.setEmailId("42");
        user8.setEmployee(employee7);
        user8.setFirstName("Jane");
        user8.setGender("Gender");
        user8.setLastName("Doe");
        user8.setMobileNumber(1L);
        user8.setOtp(otp8);
        user8.setPassword("iloveyou");
        user8.setTypeOfUser("Type Of User");
        user8.setUserId(1);
        user8.setUserName("janedoe");
        user8.setZipcode(1L);
        actualEmployee.setUser(user8);
        actualEmployee.setUserName("janedoe");
        String actualToStringResult = actualEmployee.toString();
        LocalDate actualDateOfHire = actualEmployee.getDateOfHire();
        String actualDesignation = actualEmployee.getDesignation();
        String actualEmailId = actualEmployee.getEmailId();
        int actualEmployeeId = actualEmployee.getEmployeeId();
        String actualEmployeeName = actualEmployee.getEmployeeName();
        String actualEmployeeType = actualEmployee.getEmployeeType();
        String actualGender = actualEmployee.getGender();
        Set<Location> actualLocations = actualEmployee.getLocations();
        long actualMobileNumber = actualEmployee.getMobileNumber();
        List<OnlineSales> actualOnlineSales = actualEmployee.getOnlineSales();
        String actualPassword = actualEmployee.getPassword();
        long actualSalary = actualEmployee.getSalary();
        User actualUser = actualEmployee.getUser();

        // Assert that nothing has changed
        assertEquals("42", actualEmailId);
        assertEquals("Designation", actualDesignation);
        assertEquals("Employee Name", actualEmployeeName);
        assertEquals("Employee Type", actualEmployeeType);
        assertEquals("Employee [employeeId=1, employeeName=Employee Name, userName=janedoe, password=iloveyou, employeeType"
                + "=Employee Type, emailId=42, dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1,"
                + " designation=Designation, user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane,"
                + " lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User,"
                + " customer=Customer [customerId=1, username=janedoe, password=iloveyou, fullName=Dr Jane Doe, emailId=42,"
                + " + gender=Gender, mobileNumber=1, zipcode=1, user=User [userId=1, userName=janedoe, password=iloveyou,"
                + " firstName=Jane, lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type"
                + " Of User, customer=Customer [customerId=1, username=janedoe, password=iloveyou, fullName=Dr Jane Doe,"
                + " emailId=42, + gender=Gender, mobileNumber=1, zipcode=1, user=User [userId=0, userName=null, password=null,"
                + " firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0, zipcode=0, typeOfUser=null,"
                + " customer=null, employee=null, otp=null], vehicles=[], onlineSales=[]], employee=Employee [employeeId=1,"
                + " employeeName=Employee Name, userName=janedoe, password=iloveyou, employeeType=Employee Type, emailId=42,"
                + " dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1, designation=Designation, user=User"
                + " [userId=0, userName=null, password=null, firstName=null, lastName=null, emailId=null, gender=null,"
                + " mobileNumber=0, zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null], locations=[],"
                + " onlineSales=[]], otp=OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=0,"
                + " userName=null, password=null, firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0,"
                + " zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null]]], vehicles=[], onlineSales=[]],"
                + " employee=Employee [employeeId=1, employeeName=Employee Name, userName=janedoe, password=iloveyou,"
                + " employeeType=Employee Type, emailId=42, dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1,"
                + " designation=Designation, user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane,"
                + " lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User,"
                + " customer=Customer [customerId=1, username=janedoe, password=iloveyou, fullName=Dr Jane Doe, emailId=42,"
                + " + gender=Gender, mobileNumber=1, zipcode=1, user=User [userId=0, userName=null, password=null,"
                + " firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0, zipcode=0, typeOfUser=null,"
                + " customer=null, employee=null, otp=null], vehicles=[], onlineSales=[]], employee=Employee [employeeId=1,"
                + " employeeName=Employee Name, userName=janedoe, password=iloveyou, employeeType=Employee Type, emailId=42,"
                + " dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1, designation=Designation, user=User"
                + " [userId=0, userName=null, password=null, firstName=null, lastName=null, emailId=null, gender=null,"
                + " mobileNumber=0, zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null], locations=[],"
                + " onlineSales=[]], otp=OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=0,"
                + " userName=null, password=null, firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0,"
                + " zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null]]], locations=[], onlineSales=[]],"
                + " otp=OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=1, userName=janedoe,"
                + " password=iloveyou, firstName=Jane, lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1,"
                + " typeOfUser=Type Of User, customer=Customer [customerId=1, username=janedoe, password=iloveyou,"
                + " fullName=Dr Jane Doe, emailId=42, + gender=Gender, mobileNumber=1, zipcode=1, user=User [userId=0,"
                + " userName=null, password=null, firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0,"
                + " zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null], vehicles=[], onlineSales=[]],"
                + " employee=Employee [employeeId=1, employeeName=Employee Name, userName=janedoe, password=iloveyou,"
                + " employeeType=Employee Type, emailId=42, dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1,"
                + " designation=Designation, user=User [userId=0, userName=null, password=null, firstName=null, lastName=null,"
                + " emailId=null, gender=null, mobileNumber=0, zipcode=0, typeOfUser=null, customer=null, employee=null,"
                + " otp=null], locations=[], onlineSales=[]], otp=OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00,"
                + " user=User [userId=0, userName=null, password=null, firstName=null, lastName=null, emailId=null,"
                + " gender=null, mobileNumber=0, zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null]]]]],"
                + " locations=[], onlineSales=[]]", actualToStringResult);
        assertEquals("Gender", actualGender);
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualEmployee.getUserName());
        assertEquals(1, actualEmployeeId);
        assertEquals(1L, actualMobileNumber);
        assertEquals(1L, actualSalary);
        assertEquals(onlineSales, actualOnlineSales);
        assertSame(user8, actualUser);
        assertSame(onlineSales2, actualOnlineSales);
        assertSame(locations, actualLocations);
        assertSame(dateOfHire, actualDateOfHire);
    }

    /**
     * Method under test:
     * {@link Employee#Employee(int, String, String, String, String, LocalDate, String, long, User, Set, List)}
     */
    @Test
    void testNewEmployee() {
        // Arrange
        LocalDate dateOfHire = LocalDate.of(1970, 1, 1);

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setEmailId("42");
        customer.setFullName("Dr Jane Doe");
        customer.setGender("Gender");
        customer.setMobileNumber(1L);
        customer.setOnlineSales(new ArrayList<>());
        customer.setPassword("iloveyou");
        customer.setUser(new User());
        customer.setUsername("janedoe");
        customer.setVehicles(new ArrayList<>());
        customer.setZipcode(1L);

        Employee employee2 = new Employee();
        employee2.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee2.setDesignation("Designation");
        employee2.setEmailId("42");
        employee2.setEmployeeId(1);
        employee2.setEmployeeName("Employee Name");
        employee2.setEmployeeType("Employee Type");
        employee2.setGender("Gender");
        employee2.setLocations(new HashSet<>());
        employee2.setMobileNumber(1L);
        employee2.setOnlineSales(new ArrayList<>());
        employee2.setPassword("iloveyou");
        employee2.setSalary(1L);
        employee2.setUser(new User());
        employee2.setUserName("janedoe");

        OneTimePasscode otp = new OneTimePasscode();
        otp.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp.setId(1);
        otp.setOtp(1L);
        otp.setUser(new User());

        User user = new User();
        user.setCustomer(customer);
        user.setEmailId("42");
        user.setEmployee(employee2);
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setMobileNumber(1L);
        user.setOtp(otp);
        user.setPassword("iloveyou");
        user.setTypeOfUser("Type Of User");
        user.setUserId(1);
        user.setUserName("janedoe");
        user.setZipcode(1L);

        Customer customer2 = new Customer();
        customer2.setCustomerId(1);
        customer2.setEmailId("42");
        customer2.setFullName("Dr Jane Doe");
        customer2.setGender("Gender");
        customer2.setMobileNumber(1L);
        customer2.setOnlineSales(new ArrayList<>());
        customer2.setPassword("iloveyou");
        customer2.setUser(user);
        customer2.setUsername("janedoe");
        customer2.setVehicles(new ArrayList<>());
        customer2.setZipcode(1L);

        Customer customer3 = new Customer();
        customer3.setCustomerId(1);
        customer3.setEmailId("42");
        customer3.setFullName("Dr Jane Doe");
        customer3.setGender("Gender");
        customer3.setMobileNumber(1L);
        customer3.setOnlineSales(new ArrayList<>());
        customer3.setPassword("iloveyou");
        customer3.setUser(new User());
        customer3.setUsername("janedoe");
        customer3.setVehicles(new ArrayList<>());
        customer3.setZipcode(1L);

        Employee employee3 = new Employee();
        employee3.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee3.setDesignation("Designation");
        employee3.setEmailId("42");
        employee3.setEmployeeId(1);
        employee3.setEmployeeName("Employee Name");
        employee3.setEmployeeType("Employee Type");
        employee3.setGender("Gender");
        employee3.setLocations(new HashSet<>());
        employee3.setMobileNumber(1L);
        employee3.setOnlineSales(new ArrayList<>());
        employee3.setPassword("iloveyou");
        employee3.setSalary(1L);
        employee3.setUser(new User());
        employee3.setUserName("janedoe");

        OneTimePasscode otp2 = new OneTimePasscode();
        otp2.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp2.setId(1);
        otp2.setOtp(1L);
        otp2.setUser(new User());

        User user2 = new User();
        user2.setCustomer(customer3);
        user2.setEmailId("42");
        user2.setEmployee(employee3);
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setLastName("Doe");
        user2.setMobileNumber(1L);
        user2.setOtp(otp2);
        user2.setPassword("iloveyou");
        user2.setTypeOfUser("Type Of User");
        user2.setUserId(1);
        user2.setUserName("janedoe");
        user2.setZipcode(1L);

        Employee employee4 = new Employee();
        employee4.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee4.setDesignation("Designation");
        employee4.setEmailId("42");
        employee4.setEmployeeId(1);
        employee4.setEmployeeName("Employee Name");
        employee4.setEmployeeType("Employee Type");
        employee4.setGender("Gender");
        employee4.setLocations(new HashSet<>());
        employee4.setMobileNumber(1L);
        employee4.setOnlineSales(new ArrayList<>());
        employee4.setPassword("iloveyou");
        employee4.setSalary(1L);
        employee4.setUser(user2);
        employee4.setUserName("janedoe");

        Customer customer4 = new Customer();
        customer4.setCustomerId(1);
        customer4.setEmailId("42");
        customer4.setFullName("Dr Jane Doe");
        customer4.setGender("Gender");
        customer4.setMobileNumber(1L);
        customer4.setOnlineSales(new ArrayList<>());
        customer4.setPassword("iloveyou");
        customer4.setUser(new User());
        customer4.setUsername("janedoe");
        customer4.setVehicles(new ArrayList<>());
        customer4.setZipcode(1L);

        Employee employee5 = new Employee();
        employee5.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee5.setDesignation("Designation");
        employee5.setEmailId("42");
        employee5.setEmployeeId(1);
        employee5.setEmployeeName("Employee Name");
        employee5.setEmployeeType("Employee Type");
        employee5.setGender("Gender");
        employee5.setLocations(new HashSet<>());
        employee5.setMobileNumber(1L);
        employee5.setOnlineSales(new ArrayList<>());
        employee5.setPassword("iloveyou");
        employee5.setSalary(1L);
        employee5.setUser(new User());
        employee5.setUserName("janedoe");

        OneTimePasscode otp3 = new OneTimePasscode();
        otp3.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp3.setId(1);
        otp3.setOtp(1L);
        otp3.setUser(new User());

        User user3 = new User();
        user3.setCustomer(customer4);
        user3.setEmailId("42");
        user3.setEmployee(employee5);
        user3.setFirstName("Jane");
        user3.setGender("Gender");
        user3.setLastName("Doe");
        user3.setMobileNumber(1L);
        user3.setOtp(otp3);
        user3.setPassword("iloveyou");
        user3.setTypeOfUser("Type Of User");
        user3.setUserId(1);
        user3.setUserName("janedoe");
        user3.setZipcode(1L);

        OneTimePasscode otp4 = new OneTimePasscode();
        otp4.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp4.setId(1);
        otp4.setOtp(1L);
        otp4.setUser(user3);

        User user4 = new User();
        user4.setCustomer(customer2);
        user4.setEmailId("42");
        user4.setEmployee(employee4);
        user4.setFirstName("Jane");
        user4.setGender("Gender");
        user4.setLastName("Doe");
        user4.setMobileNumber(1L);
        user4.setOtp(otp4);
        user4.setPassword("iloveyou");
        user4.setTypeOfUser("Type Of User");
        user4.setUserId(1);
        user4.setUserName("janedoe");
        user4.setZipcode(1L);
        HashSet<Location> locations = new HashSet<>();

        // Act and Assert

        User user5 = (new Employee(1, "Employee Name", "iloveyou", "42", "janedoe", null, 0, user4)).getUser();
        LocalTime expectedToLocalTimeResult = user5.getOtp().getGeneratedTime().toLocalTime();
        assertSame(expectedToLocalTimeResult, user5.getEmployee().getUser().getOtp().getGeneratedTime().toLocalTime());
    }

    /**
     * Method under test:
     * {@link Employee#Employee(int, String, String, String, String, LocalDate, String, long, User, Set, List)}
     */
    @Test
    void testNewEmployee2() {
        // Arrange
        LocalDate dateOfHire = LocalDate.of(1970, 1, 1);

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setEmailId("42");
        customer.setFullName("Dr Jane Doe");
        customer.setGender("Gender");
        customer.setMobileNumber(1L);
        customer.setOnlineSales(new ArrayList<>());
        customer.setPassword("iloveyou");
        customer.setUser(new User());
        customer.setUsername("janedoe");
        customer.setVehicles(new ArrayList<>());
        customer.setZipcode(1L);

        Employee employee2 = new Employee();
        employee2.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee2.setDesignation("Designation");
        employee2.setEmailId("42");
        employee2.setEmployeeId(1);
        employee2.setEmployeeName("Employee Name");
        employee2.setEmployeeType("Employee Type");
        employee2.setGender("Gender");
        employee2.setLocations(new HashSet<>());
        employee2.setMobileNumber(1L);
        employee2.setOnlineSales(new ArrayList<>());
        employee2.setPassword("iloveyou");
        employee2.setSalary(1L);
        employee2.setUser(new User());
        employee2.setUserName("janedoe");

        OneTimePasscode otp = new OneTimePasscode();
        otp.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp.setId(1);
        otp.setOtp(1L);
        otp.setUser(new User());

        User user = new User();
        user.setCustomer(customer);
        user.setEmailId("42");
        user.setEmployee(employee2);
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setLastName("Doe");
        user.setMobileNumber(1L);
        user.setOtp(otp);
        user.setPassword("iloveyou");
        user.setTypeOfUser("Type Of User");
        user.setUserId(1);
        user.setUserName("janedoe");
        user.setZipcode(1L);

        Customer customer2 = new Customer();
        customer2.setCustomerId(1);
        customer2.setEmailId("42");
        customer2.setFullName("Dr Jane Doe");
        customer2.setGender("Gender");
        customer2.setMobileNumber(1L);
        ArrayList<OnlineSales> onlineSales = new ArrayList<>();
        customer2.setOnlineSales(onlineSales);
        customer2.setPassword("iloveyou");
        customer2.setUser(user);
        customer2.setUsername("janedoe");
        customer2.setVehicles(new ArrayList<>());
        customer2.setZipcode(1L);

        Customer customer3 = new Customer();
        customer3.setCustomerId(1);
        customer3.setEmailId("42");
        customer3.setFullName("Dr Jane Doe");
        customer3.setGender("Gender");
        customer3.setMobileNumber(1L);
        customer3.setOnlineSales(new ArrayList<>());
        customer3.setPassword("iloveyou");
        customer3.setUser(new User());
        customer3.setUsername("janedoe");
        customer3.setVehicles(new ArrayList<>());
        customer3.setZipcode(1L);

        Employee employee3 = new Employee();
        employee3.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee3.setDesignation("Designation");
        employee3.setEmailId("42");
        employee3.setEmployeeId(1);
        employee3.setEmployeeName("Employee Name");
        employee3.setEmployeeType("Employee Type");
        employee3.setGender("Gender");
        employee3.setLocations(new HashSet<>());
        employee3.setMobileNumber(1L);
        employee3.setOnlineSales(new ArrayList<>());
        employee3.setPassword("iloveyou");
        employee3.setSalary(1L);
        employee3.setUser(new User());
        employee3.setUserName("janedoe");

        OneTimePasscode otp2 = new OneTimePasscode();
        otp2.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp2.setId(1);
        otp2.setOtp(1L);
        otp2.setUser(new User());

        User user2 = new User();
        user2.setCustomer(customer3);
        user2.setEmailId("42");
        user2.setEmployee(employee3);
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setLastName("Doe");
        user2.setMobileNumber(1L);
        user2.setOtp(otp2);
        user2.setPassword("iloveyou");
        user2.setTypeOfUser("Type Of User");
        user2.setUserId(1);
        user2.setUserName("janedoe");
        user2.setZipcode(1L);

        Employee employee4 = new Employee();
        employee4.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee4.setDesignation("Designation");
        employee4.setEmailId("42");
        employee4.setEmployeeId(1);
        employee4.setEmployeeName("Employee Name");
        employee4.setEmployeeType("Employee Type");
        employee4.setGender("Gender");
        employee4.setLocations(new HashSet<>());
        employee4.setMobileNumber(1L);
        employee4.setOnlineSales(new ArrayList<>());
        employee4.setPassword("iloveyou");
        employee4.setSalary(1L);
        employee4.setUser(user2);
        employee4.setUserName("janedoe");

        Customer customer4 = new Customer();
        customer4.setCustomerId(1);
        customer4.setEmailId("42");
        customer4.setFullName("Dr Jane Doe");
        customer4.setGender("Gender");
        customer4.setMobileNumber(1L);
        customer4.setOnlineSales(new ArrayList<>());
        customer4.setPassword("iloveyou");
        customer4.setUser(new User());
        customer4.setUsername("janedoe");
        customer4.setVehicles(new ArrayList<>());
        customer4.setZipcode(1L);

        Employee employee5 = new Employee();
        employee5.setDateOfHire(LocalDate.of(1970, 1, 1));
        employee5.setDesignation("Designation");
        employee5.setEmailId("42");
        employee5.setEmployeeId(1);
        employee5.setEmployeeName("Employee Name");
        employee5.setEmployeeType("Employee Type");
        employee5.setGender("Gender");
        employee5.setLocations(new HashSet<>());
        employee5.setMobileNumber(1L);
        employee5.setOnlineSales(new ArrayList<>());
        employee5.setPassword("iloveyou");
        employee5.setSalary(1L);
        employee5.setUser(new User());
        employee5.setUserName("janedoe");

        OneTimePasscode otp3 = new OneTimePasscode();
        otp3.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp3.setId(1);
        otp3.setOtp(1L);
        otp3.setUser(new User());

        User user3 = new User();
        user3.setCustomer(customer4);
        user3.setEmailId("42");
        user3.setEmployee(employee5);
        user3.setFirstName("Jane");
        user3.setGender("Gender");
        user3.setLastName("Doe");
        user3.setMobileNumber(1L);
        user3.setOtp(otp3);
        user3.setPassword("iloveyou");
        user3.setTypeOfUser("Type Of User");
        user3.setUserId(1);
        user3.setUserName("janedoe");
        user3.setZipcode(1L);

        OneTimePasscode otp4 = new OneTimePasscode();
        otp4.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp4.setId(1);
        otp4.setOtp(1L);
        otp4.setUser(user3);
        User user4 = mock(User.class);
        doNothing().when(user4).setCustomer(Mockito.<Customer>any());
        doNothing().when(user4).setEmailId(Mockito.<String>any());
        doNothing().when(user4).setEmployee(Mockito.<Employee>any());
        doNothing().when(user4).setFirstName(Mockito.<String>any());
        doNothing().when(user4).setGender(Mockito.<String>any());
        doNothing().when(user4).setLastName(Mockito.<String>any());
        doNothing().when(user4).setMobileNumber(anyLong());
        doNothing().when(user4).setOtp(Mockito.<OneTimePasscode>any());
        doNothing().when(user4).setPassword(Mockito.<String>any());
        doNothing().when(user4).setTypeOfUser(Mockito.<String>any());
        doNothing().when(user4).setUserId(anyInt());
        doNothing().when(user4).setUserName(Mockito.<String>any());
        doNothing().when(user4).setZipcode(anyLong());
        user4.setCustomer(customer2);
        user4.setEmailId("42");
        user4.setEmployee(employee4);
        user4.setFirstName("Jane");
        user4.setGender("Gender");
        user4.setLastName("Doe");
        user4.setMobileNumber(1L);
        user4.setOtp(otp4);
        user4.setPassword("iloveyou");
        user4.setTypeOfUser("Type Of User");
        user4.setUserId(1);
        user4.setUserName("janedoe");
        user4.setZipcode(1L);
        HashSet<Location> locations = new HashSet<>();

        // Act
        Employee actualEmployee =  new Employee(1, "Employee Name", "iloveyou", "42", "janedoe", null, 0, user4);

        // Assert
        verify(user4).setCustomer(Mockito.<Customer>any());
        verify(user4).setEmailId(eq("42"));
        verify(user4).setEmployee(Mockito.<Employee>any());
        verify(user4).setFirstName(eq("Jane"));
        verify(user4).setGender(eq("Gender"));
        verify(user4).setLastName(eq("Doe"));
        verify(user4).setMobileNumber(eq(1L));
        verify(user4).setOtp(Mockito.<OneTimePasscode>any());
        verify(user4).setPassword(eq("iloveyou"));
        verify(user4).setTypeOfUser(eq("Type Of User"));
        verify(user4).setUserId(eq(1));
        verify(user4).setUserName(eq("janedoe"));
        verify(user4).setZipcode(eq(1L));
      
    }
}
