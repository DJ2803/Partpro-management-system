package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class OneTimePasscodeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link OneTimePasscode#OneTimePasscode()}
     *   <li>{@link OneTimePasscode#setGeneratedTime(LocalDateTime)}
     *   <li>{@link OneTimePasscode#setId(int)}
     *   <li>{@link OneTimePasscode#setOtp(long)}
     *   <li>{@link OneTimePasscode#setUser(User)}
     *   <li>{@link OneTimePasscode#toString()}
     *   <li>{@link OneTimePasscode#getGeneratedTime()}
     *   <li>{@link OneTimePasscode#getId()}
     *   <li>{@link OneTimePasscode#getOtp()}
     *   <li>{@link OneTimePasscode#getUser()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        OneTimePasscode actualOneTimePasscode = new OneTimePasscode();
        LocalDateTime generatedTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualOneTimePasscode.setGeneratedTime(generatedTime);
        actualOneTimePasscode.setId(1);
        actualOneTimePasscode.setOtp(1L);
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
        actualOneTimePasscode.setUser(user4);
        String actualToStringResult = actualOneTimePasscode.toString();
        LocalDateTime actualGeneratedTime = actualOneTimePasscode.getGeneratedTime();
        int actualId = actualOneTimePasscode.getId();
        long actualOtp = actualOneTimePasscode.getOtp();

        // Assert that nothing has changed
        assertEquals("OneTimePasscode [id=1, otp=1, generatedTime=1970-01-01T00:00, user=User [userId=1, userName=janedoe,"
                + " password=iloveyou, firstName=Jane, lastName=Doe, emailId=42, gender=Gender, mobileNumber=1, zipcode=1,"
                + " typeOfUser=Type Of User, customer=Customer [customerId=1, username=janedoe, password=iloveyou,"
                + " fullName=Dr Jane Doe, emailId=42, + gender=Gender, mobileNumber=1, zipcode=1, user=User [userId=1,"
                + " userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe, emailId=42, gender=Gender,"
                + " mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer [customerId=1, username=janedoe,"
                + " password=iloveyou, fullName=Dr Jane Doe, emailId=42, + gender=Gender, mobileNumber=1, zipcode=1,"
                + " user=User [userId=0, userName=null, password=null, firstName=null, lastName=null, emailId=null,"
                + " gender=null, mobileNumber=0, zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null],"
                + " vehicles=[], onlineSales=[]], employee=Employee [employeeId=1, employeeName=Employee Name, userName=janedoe,"
                + " password=iloveyou, employeeType=Employee Type, emailId=42, dateOfHire=1970-01-01, gender=Gender,"
                + " mobileNumber=1, salary=1, designation=Designation, user=User [userId=0, userName=null, password=null,"
                + " firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0, zipcode=0, typeOfUser=null,"
                + " customer=null, employee=null, otp=null], locations=[], onlineSales=[]], otp=OneTimePasscode [id=1,"
                + " otp=1, generatedTime=1970-01-01T00:00, user=User [userId=0, userName=null, password=null, firstName=null,"
                + " lastName=null, emailId=null, gender=null, mobileNumber=0, zipcode=0, typeOfUser=null, customer=null,"
                + " employee=null, otp=null]]], vehicles=[], onlineSales=[]], employee=Employee [employeeId=1,"
                + " employeeName=Employee Name, userName=janedoe, password=iloveyou, employeeType=Employee Type, emailId=42,"
                + " dateOfHire=1970-01-01, gender=Gender, mobileNumber=1, salary=1, designation=Designation, user=User"
                + " [userId=1, userName=janedoe, password=iloveyou, firstName=Jane, lastName=Doe, emailId=42, gender=Gender,"
                + " mobileNumber=1, zipcode=1, typeOfUser=Type Of User, customer=Customer [customerId=1, username=janedoe,"
                + " password=iloveyou, fullName=Dr Jane Doe, emailId=42, + gender=Gender, mobileNumber=1, zipcode=1,"
                + " user=User [userId=0, userName=null, password=null, firstName=null, lastName=null, emailId=null,"
                + " gender=null, mobileNumber=0, zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null],"
                + " vehicles=[], onlineSales=[]], employee=Employee [employeeId=1, employeeName=Employee Name, userName=janedoe,"
                + " password=iloveyou, employeeType=Employee Type, emailId=42, dateOfHire=1970-01-01, gender=Gender,"
                + " mobileNumber=1, salary=1, designation=Designation, user=User [userId=0, userName=null, password=null,"
                + " firstName=null, lastName=null, emailId=null, gender=null, mobileNumber=0, zipcode=0, typeOfUser=null,"
                + " customer=null, employee=null, otp=null], locations=[], onlineSales=[]], otp=OneTimePasscode [id=1,"
                + " otp=1, generatedTime=1970-01-01T00:00, user=User [userId=0, userName=null, password=null, firstName=null,"
                + " lastName=null, emailId=null, gender=null, mobileNumber=0, zipcode=0, typeOfUser=null, customer=null,"
                + " employee=null, otp=null]]], locations=[], onlineSales=[]], otp=OneTimePasscode [id=1, otp=1,"
                + " generatedTime=1970-01-01T00:00, user=User [userId=1, userName=janedoe, password=iloveyou, firstName=Jane,"
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
                + " zipcode=0, typeOfUser=null, customer=null, employee=null, otp=null]]]]]]", actualToStringResult);
        assertEquals(1, actualId);
        assertEquals(1L, actualOtp);
        assertSame(user4, actualOneTimePasscode.getUser());
        assertSame(generatedTime, actualGeneratedTime);
    }
}
