package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {User.class})
@ExtendWith(SpringExtension.class)
class UserTest {
    @Autowired
    private User user;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setCustomer(Customer)}
     *   <li>{@link User#setEmailId(String)}
     *   <li>{@link User#setEmployee(Employee)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setGender(String)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setMobileNumber(long)}
     *   <li>{@link User#setOtp(OneTimePasscode)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setTypeOfUser(String)}
     *   <li>{@link User#setUserId(int)}
     *   <li>{@link User#setUserName(String)}
     *   <li>{@link User#setZipcode(long)}
     *   <li>{@link User#toString()}
     *   <li>{@link User#getCustomer()}
     *   <li>{@link User#getEmailId()}
     *   <li>{@link User#getEmployee()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getGender()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getMobileNumber()}
     *   <li>{@link User#getOtp()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getTypeOfUser()}
     *   <li>{@link User#getUserId()}
     *   <li>{@link User#getUserName()}
     *   <li>{@link User#getZipcode()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        User actualUser = new User();
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
        actualUser.setCustomer(customer2);
        actualUser.setEmailId("42");
        User user5 = new User();
        user5.setCustomer(new Customer());
        user5.setEmailId("42");
        user5.setEmployee(new Employee());
        user5.setFirstName("Jane");
        user5.setGender("Gender");
        user5.setLastName("Doe");
        user5.setMobileNumber(1L);
        user5.setOtp(new OneTimePasscode());
        user5.setPassword("iloveyou");
        user5.setTypeOfUser("Type Of User");
        user5.setUserId(1);
        user5.setUserName("janedoe");
        user5.setZipcode(1L);
        Customer customer3 = new Customer();
        customer3.setCustomerId(1);
        customer3.setEmailId("42");
        customer3.setFullName("Dr Jane Doe");
        customer3.setGender("Gender");
        customer3.setMobileNumber(1L);
        customer3.setOnlineSales(new ArrayList<>());
        customer3.setPassword("iloveyou");
        customer3.setUser(user5);
        customer3.setUsername("janedoe");
        customer3.setVehicles(new ArrayList<>());
        customer3.setZipcode(1L);
        User user6 = new User();
        user6.setCustomer(new Customer());
        user6.setEmailId("42");
        user6.setEmployee(new Employee());
        user6.setFirstName("Jane");
        user6.setGender("Gender");
        user6.setLastName("Doe");
        user6.setMobileNumber(1L);
        user6.setOtp(new OneTimePasscode());
        user6.setPassword("iloveyou");
        user6.setTypeOfUser("Type Of User");
        user6.setUserId(1);
        user6.setUserName("janedoe");
        user6.setZipcode(1L);
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
        employee2.setUser(user6);
        employee2.setUserName("janedoe");
        User user7 = new User();
        user7.setCustomer(new Customer());
        user7.setEmailId("42");
        user7.setEmployee(new Employee());
        user7.setFirstName("Jane");
        user7.setGender("Gender");
        user7.setLastName("Doe");
        user7.setMobileNumber(1L);
        user7.setOtp(new OneTimePasscode());
        user7.setPassword("iloveyou");
        user7.setTypeOfUser("Type Of User");
        user7.setUserId(1);
        user7.setUserName("janedoe");
        user7.setZipcode(1L);
        OneTimePasscode otp2 = new OneTimePasscode();
        otp2.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp2.setId(1);
        otp2.setOtp(1L);
        otp2.setUser(user7);
        User user8 = new User();
        user8.setCustomer(customer3);
        user8.setEmailId("42");
        user8.setEmployee(employee2);
        user8.setFirstName("Jane");
        user8.setGender("Gender");
        user8.setLastName("Doe");
        user8.setMobileNumber(1L);
        user8.setOtp(otp2);
        user8.setPassword("iloveyou");
        user8.setTypeOfUser("Type Of User");
        user8.setUserId(1);
        user8.setUserName("janedoe");
        user8.setZipcode(1L);
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
        employee3.setUser(user8);
        employee3.setUserName("janedoe");
        actualUser.setEmployee(employee3);
        actualUser.setFirstName("Jane");
        actualUser.setGender("Gender");
        actualUser.setLastName("Doe");
        actualUser.setMobileNumber(1L);
        User user9 = new User();
        user9.setCustomer(new Customer());
        user9.setEmailId("42");
        user9.setEmployee(new Employee());
        user9.setFirstName("Jane");
        user9.setGender("Gender");
        user9.setLastName("Doe");
        user9.setMobileNumber(1L);
        user9.setOtp(new OneTimePasscode());
        user9.setPassword("iloveyou");
        user9.setTypeOfUser("Type Of User");
        user9.setUserId(1);
        user9.setUserName("janedoe");
        user9.setZipcode(1L);
        Customer customer4 = new Customer();
        customer4.setCustomerId(1);
        customer4.setEmailId("42");
        customer4.setFullName("Dr Jane Doe");
        customer4.setGender("Gender");
        customer4.setMobileNumber(1L);
        customer4.setOnlineSales(new ArrayList<>());
        customer4.setPassword("iloveyou");
        customer4.setUser(user9);
        customer4.setUsername("janedoe");
        customer4.setVehicles(new ArrayList<>());
        customer4.setZipcode(1L);
        User user10 = new User();
        user10.setCustomer(new Customer());
        user10.setEmailId("42");
        user10.setEmployee(new Employee());
        user10.setFirstName("Jane");
        user10.setGender("Gender");
        user10.setLastName("Doe");
        user10.setMobileNumber(1L);
        user10.setOtp(new OneTimePasscode());
        user10.setPassword("iloveyou");
        user10.setTypeOfUser("Type Of User");
        user10.setUserId(1);
        user10.setUserName("janedoe");
        user10.setZipcode(1L);
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
        employee4.setUser(user10);
        employee4.setUserName("janedoe");
        User user11 = new User();
        user11.setCustomer(new Customer());
        user11.setEmailId("42");
        user11.setEmployee(new Employee());
        user11.setFirstName("Jane");
        user11.setGender("Gender");
        user11.setLastName("Doe");
        user11.setMobileNumber(1L);
        user11.setOtp(new OneTimePasscode());
        user11.setPassword("iloveyou");
        user11.setTypeOfUser("Type Of User");
        user11.setUserId(1);
        user11.setUserName("janedoe");
        user11.setZipcode(1L);
        OneTimePasscode otp3 = new OneTimePasscode();
        otp3.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp3.setId(1);
        otp3.setOtp(1L);
        otp3.setUser(user11);
        User user12 = new User();
        user12.setCustomer(customer4);
        user12.setEmailId("42");
        user12.setEmployee(employee4);
        user12.setFirstName("Jane");
        user12.setGender("Gender");
        user12.setLastName("Doe");
        user12.setMobileNumber(1L);
        user12.setOtp(otp3);
        user12.setPassword("iloveyou");
        user12.setTypeOfUser("Type Of User");
        user12.setUserId(1);
        user12.setUserName("janedoe");
        user12.setZipcode(1L);
        OneTimePasscode otp4 = new OneTimePasscode();
        otp4.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp4.setId(1);
        otp4.setOtp(1L);
        otp4.setUser(user12);
        actualUser.setOtp(otp4);
        actualUser.setPassword("iloveyou");
        actualUser.setTypeOfUser("Type Of User");
        actualUser.setUserId(1);
        actualUser.setUserName("janedoe");
        actualUser.setZipcode(1L);
        String actualToStringResult = actualUser.toString();
        Customer actualCustomer = actualUser.getCustomer();
        String actualEmailId = actualUser.getEmailId();
        Employee actualEmployee = actualUser.getEmployee();
        String actualFirstName = actualUser.getFirstName();
        String actualGender = actualUser.getGender();
        String actualLastName = actualUser.getLastName();
        long actualMobileNumber = actualUser.getMobileNumber();
        OneTimePasscode actualOtp = actualUser.getOtp();
        String actualPassword = actualUser.getPassword();
        String actualTypeOfUser = actualUser.getTypeOfUser();
        int actualUserId = actualUser.getUserId();
        String actualUserName = actualUser.getUserName();

        // Assert that nothing has changed
        assertEquals("42", actualEmailId);
        assertEquals("Doe", actualLastName);
        assertEquals("Gender", actualGender);
        assertEquals("Jane", actualFirstName);
        assertEquals("Type Of User", actualTypeOfUser);
        assertEquals("User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe, emailId=42,"
                        + " gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer [customerId=1,"
                        + " username=janedoe, password=iloveyou, fullName=Dr Jane Doe, emailId=42, + gender=Gender, mobileNumber=1,"
                        + " zipcode=1, user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe,"
                        + " emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer"
                        + " [customerId=1, username=janedoe, password=iloveyou, fullName=Dr Jane Doe, emailId=42, + gender=Gender,"
                        + " mobileNumber=1, zipcode=1, user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane,"
                        + " lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User,"
                        + " customer=Customer [customerId=0, username=null, password=null, fullName=null, emailId=null, +"
                        + " gender=null, mobileNumber=0, zipcode=0, user=null, vehicles=[], onlineSales=[]], employee=Employee"
                        + " [employeeId=0, employeeName=null, userName=null, password=null, employeeType=null, emailId=null,"
                        + " dateOfHire=null, gender=null, mobileNumber=0, salary=0, designation=null, user=null, locations=[],"
                        + " onlineSales=[]], otp=OneTimePasscode [id=0, otp=0, generatedTime=null, user=null]], vehicles=[],"
                        + " onlineSales=[]], employee=Employee [employeeId=1, employeeName=Employee Name, userName=janedoe,"
                        + " password=iloveyou, employeeType=Employee Type, emailId=42, dateOfHire=1970-01-01, gender=Gender,"
                        + " mobileNumber=1, salary=1, designation=Designation, user=User [userId=1, userName=janedoe, password=iloveyou,"
                        + " firstName=Jane, lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type"
                        + " Of User, customer=Customer [customerId=0, username=null, password=null, fullName=null, emailId=null,"
                        + " + gender=null, mobileNumber=0, zipcode=0, user=null, vehicles=[], onlineSales=[]], employee=Employee"
                        + " [employeeId=0, employeeName=null, userName=null, password=null, employeeType=null, emailId=null,"
                        + " dateOfHire=null, gender=null, mobileNumber=0, salary=0, designation=null, user=null, locations=[],"
                        + " onlineSales=[]], otp=OneTimePasscode [id=0, otp=0, generatedTime=null, user=null]], locations=[],"
                        + " onlineSales=[]], otp=OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=1,"
                        + " userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe, emailId=42, gender=Gender,"
                        + " mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer [customerId=0, username=null,"
                        + " password=null, fullName=null, emailId=null, + gender=null, mobileNumber=0, zipcode=0, user=null,"
                        + " vehicles=[], onlineSales=[]], employee=Employee [employeeId=0, employeeName=null, userName=null,"
                        + " password=null, employeeType=null, emailId=null, dateOfHire=null, gender=null, mobileNumber=0, salary=0,"
                        + " designation=null, user=null, locations=[], onlineSales=[]], otp=OneTimePasscode [id=0, otp=0,"
                        + " generatedTime=null, user=null]]]], vehicles=[], onlineSales=[]], employee=Employee [employeeId=1,"
                        + " employeeName=Employee Name, userName=janedoe, password=iloveyou, employeeType=Employee Type, emailId=42,"
                        + " dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1, designation=Designation, user=User"
                        + " [userId=1, userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe, emailId=42, gender=Gender,"
                        + " mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer [customerId=1, username=janedoe,"
                        + " password=iloveyou, fullName=Dr Jane Doe, emailId=42, + gender=Gender, mobileNumber=1, zipcode=1,"
                        + " user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe, emailId=42,"
                        + " gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer [customerId=0,"
                        + " username=null, password=null, fullName=null, emailId=null, + gender=null, mobileNumber=0, zipcode=0,"
                        + " user=null, vehicles=[], onlineSales=[]], employee=Employee [employeeId=0, employeeName=null,"
                        + " userName=null, password=null, employeeType=null, emailId=null, dateOfHire=null, gender=null,"
                        + " mobileNumber=0, salary=0, designation=null, user=null, locations=[], onlineSales=[]], otp=OneTimePasscode"
                        + " [id=0, otp=0, generatedTime=null, user=null]], vehicles=[], onlineSales=[]], employee=Employee"
                        + " [employeeId=1, employeeName=Employee Name, userName=janedoe, password=iloveyou, employeeType=Employee"
                        + " Type, emailId=42, dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1, designation=Designation,"
                        + " user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe, emailId=42,"
                        + " gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer [customerId=0,"
                        + " username=null, password=null, fullName=null, emailId=null, + gender=null, mobileNumber=0, zipcode=0,"
                        + " user=null, vehicles=[], onlineSales=[]], employee=Employee [employeeId=0, employeeName=null,"
                        + " userName=null, password=null, employeeType=null, emailId=null, dateOfHire=null, gender=null,"
                        + " mobileNumber=0, salary=0, designation=null, user=null, locations=[], onlineSales=[]], otp=OneTimePasscode"
                        + " [id=0, otp=0, generatedTime=null, user=null]], locations=[], onlineSales=[]], otp=OneTimePasscode"
                        + " [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=1, userName=janedoe, password=iloveyou,"
                        + " firstName=Jane, lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type"
                        + " Of User, customer=Customer [customerId=0, username=null, password=null, fullName=null, emailId=null,"
                        + " + gender=null, mobileNumber=0, zipcode=0, user=null, vehicles=[], onlineSales=[]], employee=Employee"
                        + " [employeeId=0, employeeName=null, userName=null, password=null, employeeType=null, emailId=null,"
                        + " dateOfHire=null, gender=null, mobileNumber=0, salary=0, designation=null, user=null, locations=[],"
                        + " onlineSales=[]], otp=OneTimePasscode [id=0, otp=0, generatedTime=null, user=null]]]], locations=[],"
                        + " onlineSales=[]], otp=OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=1,"
                        + " userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe, emailId=42, gender=Gender,"
                        + " mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer [customerId=1, username=janedoe,"
                        + " password=iloveyou, fullName=Dr Jane Doe, emailId=42, + gender=Gender, mobileNumber=1, zipcode=1,"
                        + " user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe, emailId=42,"
                        + " gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer [customerId=0,"
                        + " username=null, password=null, fullName=null, emailId=null, + gender=null, mobileNumber=0, zipcode=0,"
                        + " user=null, vehicles=[], onlineSales=[]], employee=Employee [employeeId=0, employeeName=null,"
                        + " userName=null, password=null, employeeType=null, emailId=null, dateOfHire=null, gender=null,"
                        + " mobileNumber=0, salary=0, designation=null, user=null, locations=[], onlineSales=[]], otp=OneTimePasscode"
                        + " [id=0, otp=0, generatedTime=null, user=null]], vehicles=[], onlineSales=[]], employee=Employee"
                        + " [employeeId=1, employeeName=Employee Name, userName=janedoe, password=iloveyou, employeeType=Employee"
                        + " Type, emailId=42, dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1, designation=Designation,"
                        + " user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe, emailId=42,"
                        + " gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer [customerId=0,"
                        + " username=null, password=null, fullName=null, emailId=null, + gender=null, mobileNumber=0, zipcode=0,"
                        + " user=null, vehicles=[], onlineSales=[]], employee=Employee [employeeId=0, employeeName=null,"
                        + " userName=null, password=null, employeeType=null, emailId=null, dateOfHire=null, gender=null,"
                        + " mobileNumber=0, salary=0, designation=null, user=null, locations=[], onlineSales=[]], otp=OneTimePasscode"
                        + " [id=0, otp=0, generatedTime=null, user=null]], locations=[], onlineSales=[]], otp=OneTimePasscode"
                        + " [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=1, userName=janedoe, password=iloveyou,"
                        + " firstName=Jane, lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1, typeOfUser=Type"
                        + " Of User, customer=Customer [customerId=0, username=null, password=null, fullName=null, emailId=null,"
                        + " + gender=null, mobileNumber=0, zipcode=0, user=null, vehicles=[], onlineSales=[]], employee=Employee"
                        + " [employeeId=0, employeeName=null, userName=null, password=null, employeeType=null, emailId=null,"
                        + " dateOfHire=null, gender=null, mobileNumber=0, salary=0, designation=null, user=null, locations=[],"
                        + " onlineSales=[]], otp=OneTimePasscode [id=0, otp=0, generatedTime=null, user=null]]]]]]",
                actualToStringResult);
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualUserName);
        assertEquals(1, actualUserId);
        assertEquals(1L, actualMobileNumber);
        assertEquals(1L, actualUser.getZipcode());
        assertSame(customer2, actualCustomer);
        assertSame(employee3, actualEmployee);
        assertSame(otp4, actualOtp);
    }

    /**
     * Method under test:
     * {@link User#User(int, String, String, String, String, String, String, long, long, String)}
     */
    @Test
    void testNewUser() {
        // Arrange and Act
        User actualUser = new User(1, "janedoe", "iloveyou", "Jane", "Doe", "42", "Gender", 1L, 1L, "Type Of User");

        // Assert
        assertEquals("42", actualUser.getEmailId());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("Gender", actualUser.getGender());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Type Of User", actualUser.getTypeOfUser());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("janedoe", actualUser.getUserName());
        assertEquals(1, actualUser.getUserId());
        assertEquals(1L, actualUser.getMobileNumber());
        assertEquals(1L, actualUser.getZipcode());
    }
}
