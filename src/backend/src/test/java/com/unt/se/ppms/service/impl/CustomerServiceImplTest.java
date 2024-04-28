package com.unt.se.ppms.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.unt.se.ppms.entities.Cart;
import com.unt.se.ppms.entities.Customer;
import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.entities.OneTimePasscode;
import com.unt.se.ppms.entities.ProductCategory;
import com.unt.se.ppms.entities.Products;
import com.unt.se.ppms.entities.User;
import com.unt.se.ppms.exceptions.CustomerNotFoundException;
import com.unt.se.ppms.repository.CartRepository;
import com.unt.se.ppms.repository.CustomerRepository;
import com.unt.se.ppms.repository.FeedbackRepository;
import com.unt.se.ppms.repository.ProductsRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CustomerServiceImplTest {
    @MockBean
    private CartRepository cartRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @MockBean
    private ProductsRepository productsRepository;
    
    @MockBean
    private FeedbackRepository feedbackRepository;

    /**
     * Method under test: {@link CustomerServiceImpl#updateCustomer(int, Customer)}
     */
    @Test
    void testUpdateCustomer() throws CustomerNotFoundException {
        // Arrange
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
        Optional<Customer> ofResult = Optional.of(customer2);

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

        User user5 = new User();
        user5.setCustomer(customer3);
        user5.setEmailId("42");
        user5.setEmployee(employee2);
        user5.setFirstName("Jane");
        user5.setGender("Gender");
        user5.setLastName("Doe");
        user5.setMobileNumber(1L);
        user5.setOtp(otp2);
        user5.setPassword("iloveyou");
        user5.setTypeOfUser("Type Of User");
        user5.setUserId(1);
        user5.setUserName("janedoe");
        user5.setZipcode(1L);

        Customer customer4 = new Customer();
        customer4.setCustomerId(1);
        customer4.setEmailId("42");
        customer4.setFullName("Dr Jane Doe");
        customer4.setGender("Gender");
        customer4.setMobileNumber(1L);
        customer4.setOnlineSales(new ArrayList<>());
        customer4.setPassword("iloveyou");
        customer4.setUser(user5);
        customer4.setUsername("janedoe");
        customer4.setVehicles(new ArrayList<>());
        customer4.setZipcode(1L);

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

        OneTimePasscode otp3 = new OneTimePasscode();
        otp3.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp3.setId(1);
        otp3.setOtp(1L);
        otp3.setUser(new User());

        User user6 = new User();
        user6.setCustomer(customer5);
        user6.setEmailId("42");
        user6.setEmployee(employee3);
        user6.setFirstName("Jane");
        user6.setGender("Gender");
        user6.setLastName("Doe");
        user6.setMobileNumber(1L);
        user6.setOtp(otp3);
        user6.setPassword("iloveyou");
        user6.setTypeOfUser("Type Of User");
        user6.setUserId(1);
        user6.setUserName("janedoe");
        user6.setZipcode(1L);

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
        employee4.setUser(user6);
        employee4.setUserName("janedoe");

        Customer customer6 = new Customer();
        customer6.setCustomerId(1);
        customer6.setEmailId("42");
        customer6.setFullName("Dr Jane Doe");
        customer6.setGender("Gender");
        customer6.setMobileNumber(1L);
        customer6.setOnlineSales(new ArrayList<>());
        customer6.setPassword("iloveyou");
        customer6.setUser(new User());
        customer6.setUsername("janedoe");
        customer6.setVehicles(new ArrayList<>());
        customer6.setZipcode(1L);

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

        OneTimePasscode otp4 = new OneTimePasscode();
        otp4.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp4.setId(1);
        otp4.setOtp(1L);
        otp4.setUser(new User());

        User user7 = new User();
        user7.setCustomer(customer6);
        user7.setEmailId("42");
        user7.setEmployee(employee5);
        user7.setFirstName("Jane");
        user7.setGender("Gender");
        user7.setLastName("Doe");
        user7.setMobileNumber(1L);
        user7.setOtp(otp4);
        user7.setPassword("iloveyou");
        user7.setTypeOfUser("Type Of User");
        user7.setUserId(1);
        user7.setUserName("janedoe");
        user7.setZipcode(1L);

        OneTimePasscode otp5 = new OneTimePasscode();
        otp5.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp5.setId(1);
        otp5.setOtp(1L);
        otp5.setUser(user7);

        User user8 = new User();
        user8.setCustomer(customer4);
        user8.setEmailId("42");
        user8.setEmployee(employee4);
        user8.setFirstName("Jane");
        user8.setGender("Gender");
        user8.setLastName("Doe");
        user8.setMobileNumber(1L);
        user8.setOtp(otp5);
        user8.setPassword("iloveyou");
        user8.setTypeOfUser("Type Of User");
        user8.setUserId(1);
        user8.setUserName("janedoe");
        user8.setZipcode(1L);

        Customer customer7 = new Customer();
        customer7.setCustomerId(1);
        customer7.setEmailId("42");
        customer7.setFullName("Dr Jane Doe");
        customer7.setGender("Gender");
        customer7.setMobileNumber(1L);
        customer7.setOnlineSales(new ArrayList<>());
        customer7.setPassword("iloveyou");
        customer7.setUser(user8);
        customer7.setUsername("janedoe");
        customer7.setVehicles(new ArrayList<>());
        customer7.setZipcode(1L);
        when(customerRepository.save(Mockito.<Customer>any())).thenReturn(customer7);
        when(customerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

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

        Customer customer8 = new Customer();
        customer8.setCustomerId(1);
        customer8.setEmailId("42");
        customer8.setFullName("Dr Jane Doe");
        customer8.setGender("Gender");
        customer8.setMobileNumber(1L);
        customer8.setOnlineSales(new ArrayList<>());
        customer8.setPassword("iloveyou");
        customer8.setUser(user9);
        customer8.setUsername("janedoe");
        customer8.setVehicles(new ArrayList<>());
        customer8.setZipcode(1L);

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
        employee6.setUser(user10);
        employee6.setUserName("janedoe");

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

        OneTimePasscode otp6 = new OneTimePasscode();
        otp6.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        otp6.setId(1);
        otp6.setOtp(1L);
        otp6.setUser(user11);

        User user12 = new User();
        user12.setCustomer(customer8);
        user12.setEmailId("42");
        user12.setEmployee(employee6);
        user12.setFirstName("Jane");
        user12.setGender("Gender");
        user12.setLastName("Doe");
        user12.setMobileNumber(1L);
        user12.setOtp(otp6);
        user12.setPassword("iloveyou");
        user12.setTypeOfUser("Type Of User");
        user12.setUserId(1);
        user12.setUserName("janedoe");
        user12.setZipcode(1L);

        Customer customer9 = new Customer();
        customer9.setCustomerId(1);
        customer9.setEmailId("42");
        customer9.setFullName("Dr Jane Doe");
        customer9.setGender("Gender");
        customer9.setMobileNumber(1L);
        customer9.setOnlineSales(new ArrayList<>());
        customer9.setPassword("iloveyou");
        customer9.setUser(user12);
        customer9.setUsername("janedoe");
        customer9.setVehicles(new ArrayList<>());
        customer9.setZipcode(1L);

        // Act
        String actualUpdateCustomerResult = customerServiceImpl.updateCustomer(1, customer9);

        // Assert
        verify(customerRepository).findById(Mockito.<Integer>any());
        verify(customerRepository).save(Mockito.<Customer>any());
        assertEquals("Customer Details updated successfully", actualUpdateCustomerResult);
    }

    /**
     * Method under test: {@link CustomerServiceImpl#updateCustomer(int, Customer)}
     */
    @Test
    void testUpdateCustomer2() throws CustomerNotFoundException {
        // Arrange
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
        Optional<Customer> ofResult = Optional.of(customer2);
        when(customerRepository.save(Mockito.<Customer>any()))
                .thenThrow(new RuntimeException("Customer Details updated successfully"));
        when(customerRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

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

        Customer customer4 = new Customer();
        customer4.setCustomerId(1);
        customer4.setEmailId("42");
        customer4.setFullName("Dr Jane Doe");
        customer4.setGender("Gender");
        customer4.setMobileNumber(1L);
        customer4.setOnlineSales(new ArrayList<>());
        customer4.setPassword("iloveyou");
        customer4.setUser(user8);
        customer4.setUsername("janedoe");
        customer4.setVehicles(new ArrayList<>());
        customer4.setZipcode(1L);

        // Act and Assert
        assertThrows(CustomerNotFoundException.class, () -> customerServiceImpl.updateCustomer(1, customer4));
        verify(customerRepository).findById(Mockito.<Integer>any());
        verify(customerRepository).save(Mockito.<Customer>any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#addProductToCart(Cart)}
     */
    @Test
    void testAddProductToCart() {
        // Arrange
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        Optional<Cart> ofResult = Optional.of(cart);

        Cart cart2 = new Cart();
        cart2.setId(1L);
        cart2.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart2.setProductId(1L);
        cart2.setProductPrice(10.0d);
        cart2.setProductQuantity(1L);
        cart2.setUserId(1L);
        when(cartRepository.save(Mockito.<Cart>any())).thenReturn(cart2);
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any())).thenReturn(ofResult);

        Cart cart3 = new Cart();
        cart3.setId(1L);
        cart3.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart3.setProductId(1L);
        cart3.setProductPrice(10.0d);
        cart3.setProductQuantity(1L);
        cart3.setUserId(1L);

        // Act
        String actualAddProductToCartResult = customerServiceImpl.addProductToCart(cart3);

        // Assert
        verify(cartRepository, atLeast(1)).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cartRepository).save(Mockito.<Cart>any());
        assertEquals("Item added to cart", actualAddProductToCartResult);
    }

    /**
     * Method under test: {@link CustomerServiceImpl#addProductToCart(Cart)}
     */
    @Test
    void testAddProductToCart2() {
        // Arrange
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        Optional<Cart> ofResult = Optional.of(cart);
        when(cartRepository.save(Mockito.<Cart>any())).thenThrow(new RuntimeException("Updated product in cart"));
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any())).thenReturn(ofResult);

        Cart cart2 = new Cart();
        cart2.setId(1L);
        cart2.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart2.setProductId(1L);
        cart2.setProductPrice(10.0d);
        cart2.setProductQuantity(1L);
        cart2.setUserId(1L);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> customerServiceImpl.addProductToCart(cart2));
        verify(cartRepository, atLeast(1)).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cartRepository).save(Mockito.<Cart>any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#addProductToCart(Cart)}
     */
    @Test
    void testAddProductToCart3() {
        // Arrange
        Cart cart = mock(Cart.class);
        when(cart.getProductQuantity()).thenReturn(-1L);
        doNothing().when(cart).setId(anyLong());
        doNothing().when(cart).setOrderStatus(Mockito.<Cart.OrderStatus>any());
        doNothing().when(cart).setProductId(anyLong());
        doNothing().when(cart).setProductPrice(anyDouble());
        doNothing().when(cart).setProductQuantity(anyLong());
        doNothing().when(cart).setUserId(anyLong());
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        Optional<Cart> ofResult = Optional.of(cart);
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any())).thenReturn(ofResult);

        Cart cart2 = new Cart();
        cart2.setId(1L);
        cart2.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart2.setProductId(1L);
        cart2.setProductPrice(10.0d);
        cart2.setProductQuantity(1L);
        cart2.setUserId(1L);

        // Act
        String actualAddProductToCartResult = customerServiceImpl.addProductToCart(cart2);

        // Assert
        verify(cart, atLeast(1)).getProductQuantity();
        verify(cart).setId(eq(1L));
        verify(cart).setOrderStatus(eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cart).setProductId(eq(1L));
        verify(cart).setProductPrice(eq(10.0d));
        verify(cart).setProductQuantity(eq(1L));
        verify(cart).setUserId(eq(1L));
        verify(cartRepository, atLeast(1)).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        assertEquals("Item added to cart", actualAddProductToCartResult);
    }

    /**
     * Method under test: {@link CustomerServiceImpl#addProductToCart(Cart)}
     */
    @Test
    void testAddProductToCart4() {
        // Arrange
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        when(cartRepository.save(Mockito.<Cart>any())).thenReturn(cart);
        Optional<Cart> emptyResult = Optional.empty();
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any()))
                .thenReturn(emptyResult);

        ProductCategory category = new ProductCategory();
        category.setCategoryId(1L);
        category.setCategoryImage("Category Image");
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setProducts(new ArrayList<>());

        Products products = new Products();
        products.setBarCode("Bar Code");
        products.setCategory(category);
        products.setInventories(new ArrayList<>());
        products.setOnlineSales(new ArrayList<>());
        products.setProductDescription("Product Description");
        products.setProductId(1L);
        products.setProductImage("Product Image");
        products.setProductName("Product Name");
        products.setProductPrice(10.0f);
        products.setSuppliers(new HashSet<>());
        Optional<Products> ofResult = Optional.of(products);
        when(productsRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Cart cart2 = new Cart();
        cart2.setId(1L);
        cart2.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart2.setProductId(1L);
        cart2.setProductPrice(10.0d);
        cart2.setProductQuantity(1L);
        cart2.setUserId(1L);

        // Act
        String actualAddProductToCartResult = customerServiceImpl.addProductToCart(cart2);

        // Assert
        verify(cartRepository).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        verify(productsRepository).findById(Mockito.<Long>any());
        verify(cartRepository).save(Mockito.<Cart>any());
        assertEquals("Item added to cart", actualAddProductToCartResult);
        assertEquals(10.0d, cart2.getProductPrice());
        assertEquals(Cart.OrderStatus.NOT_ORDERED, cart2.getOrderStatus());
    }

    /**
     * Method under test:
     * {@link CustomerServiceImpl#removeProductFromCart(long, long)}
     */
    @Test
    void testRemoveProductFromCart() {
        // Arrange
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        Optional<Cart> ofResult = Optional.of(cart);
        doNothing().when(cartRepository).deleteById(Mockito.<Long>any());
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any())).thenReturn(ofResult);

        // Act
        String actualRemoveProductFromCartResult = customerServiceImpl.removeProductFromCart(1L, 1L);

        // Assert
        verify(cartRepository).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cartRepository).deleteById(Mockito.<Long>any());
        assertEquals("Item removed from cart", actualRemoveProductFromCartResult);
    }

    /**
     * Method under test:
     * {@link CustomerServiceImpl#removeProductFromCart(long, long)}
     */
    @Test
    void testRemoveProductFromCart2() {
        // Arrange
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        Optional<Cart> ofResult = Optional.of(cart);
        doThrow(new RuntimeException("Item removed from cart")).when(cartRepository).deleteById(Mockito.<Long>any());
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> customerServiceImpl.removeProductFromCart(1L, 1L));
        verify(cartRepository).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cartRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link CustomerServiceImpl#removeProductFromCart(long, long)}
     */
    @Test
    void testRemoveProductFromCart3() {
        // Arrange
        Optional<Cart> emptyResult = Optional.empty();
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any()))
                .thenReturn(emptyResult);

        // Act
        String actualRemoveProductFromCartResult = customerServiceImpl.removeProductFromCart(1L, 1L);

        // Assert
        verify(cartRepository).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        assertEquals("Item removed from cart", actualRemoveProductFromCartResult);
    }

    /**
     * Method under test:
     * {@link CustomerServiceImpl#updateProductInCart(long, long, boolean)}
     */
    @Test
    void testUpdateProductInCart() {
        // Arrange
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        Optional<Cart> ofResult = Optional.of(cart);

        Cart cart2 = new Cart();
        cart2.setId(1L);
        cart2.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart2.setProductId(1L);
        cart2.setProductPrice(10.0d);
        cart2.setProductQuantity(1L);
        cart2.setUserId(1L);
        when(cartRepository.save(Mockito.<Cart>any())).thenReturn(cart2);
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any())).thenReturn(ofResult);

        // Act
        String actualUpdateProductInCartResult = customerServiceImpl.updateProductInCart(1L, 1L, true);

        // Assert
        verify(cartRepository).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cartRepository).save(Mockito.<Cart>any());
        assertEquals("Updated product in cart", actualUpdateProductInCartResult);
    }

    /**
     * Method under test:
     * {@link CustomerServiceImpl#updateProductInCart(long, long, boolean)}
     */
    @Test
    void testUpdateProductInCart2() {
        // Arrange
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        Optional<Cart> ofResult = Optional.of(cart);
        when(cartRepository.save(Mockito.<Cart>any())).thenThrow(new RuntimeException("Updated product in cart"));
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> customerServiceImpl.updateProductInCart(1L, 1L, true));
        verify(cartRepository).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cartRepository).save(Mockito.<Cart>any());
    }

    /**
     * Method under test:
     * {@link CustomerServiceImpl#updateProductInCart(long, long, boolean)}
     */
    @Test
    void testUpdateProductInCart3() {
        // Arrange
        Cart cart = mock(Cart.class);
        when(cart.getProductQuantity()).thenReturn(-1L);
        doNothing().when(cart).setId(anyLong());
        doNothing().when(cart).setOrderStatus(Mockito.<Cart.OrderStatus>any());
        doNothing().when(cart).setProductId(anyLong());
        doNothing().when(cart).setProductPrice(anyDouble());
        doNothing().when(cart).setProductQuantity(anyLong());
        doNothing().when(cart).setUserId(anyLong());
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        Optional<Cart> ofResult = Optional.of(cart);
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any())).thenReturn(ofResult);

        // Act
        String actualUpdateProductInCartResult = customerServiceImpl.updateProductInCart(1L, 1L, true);

        // Assert
        verify(cart, atLeast(1)).getProductQuantity();
        verify(cart).setId(eq(1L));
        verify(cart).setOrderStatus(eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cart).setProductId(eq(1L));
        verify(cart).setProductPrice(eq(10.0d));
        verify(cart).setProductQuantity(eq(1L));
        verify(cart).setUserId(eq(1L));
        verify(cartRepository).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        assertEquals("Updated product in cart", actualUpdateProductInCartResult);
    }

    /**
     * Method under test:
     * {@link CustomerServiceImpl#updateProductInCart(long, long, boolean)}
     */
    @Test
    void testUpdateProductInCart4() {
        // Arrange
        Optional<Cart> emptyResult = Optional.empty();
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any()))
                .thenReturn(emptyResult);

        // Act
        String actualUpdateProductInCartResult = customerServiceImpl.updateProductInCart(1L, 1L, true);

        // Assert
        verify(cartRepository).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        assertEquals("Updated product in cart", actualUpdateProductInCartResult);
    }

    /**
     * Method under test:
     * {@link CustomerServiceImpl#updateProductInCart(long, long, boolean)}
     */
    @Test
    void testUpdateProductInCart5() {
        // Arrange
        Cart cart = mock(Cart.class);
        when(cart.getId()).thenReturn(1L);
        when(cart.getProductQuantity()).thenReturn(1L);
        doNothing().when(cart).setId(anyLong());
        doNothing().when(cart).setOrderStatus(Mockito.<Cart.OrderStatus>any());
        doNothing().when(cart).setProductId(anyLong());
        doNothing().when(cart).setProductPrice(anyDouble());
        doNothing().when(cart).setProductQuantity(anyLong());
        doNothing().when(cart).setUserId(anyLong());
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        Optional<Cart> ofResult = Optional.of(cart);
        doNothing().when(cartRepository).deleteById(Mockito.<Long>any());
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any())).thenReturn(ofResult);

        // Act
        String actualUpdateProductInCartResult = customerServiceImpl.updateProductInCart(1L, 1L, false);

        // Assert
        verify(cart).getId();
        verify(cart, atLeast(1)).getProductQuantity();
        verify(cart).setId(eq(1L));
        verify(cart).setOrderStatus(eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cart).setProductId(eq(1L));
        verify(cart).setProductPrice(eq(10.0d));
        verify(cart).setProductQuantity(eq(1L));
        verify(cart).setUserId(eq(1L));
        verify(cartRepository, atLeast(1)).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cartRepository).deleteById(Mockito.<Long>any());
        assertEquals("Updated product in cart", actualUpdateProductInCartResult);
    }

    /**
     * Method under test:
     * {@link CustomerServiceImpl#updateProductInCart(long, long, boolean)}
     */
    @Test
    void testUpdateProductInCart6() {
        // Arrange
        Cart cart = mock(Cart.class);
        when(cart.getId()).thenThrow(new RuntimeException("Item removed from cart"));
        when(cart.getProductQuantity()).thenReturn(1L);
        doNothing().when(cart).setId(anyLong());
        doNothing().when(cart).setOrderStatus(Mockito.<Cart.OrderStatus>any());
        doNothing().when(cart).setProductId(anyLong());
        doNothing().when(cart).setProductPrice(anyDouble());
        doNothing().when(cart).setProductQuantity(anyLong());
        doNothing().when(cart).setUserId(anyLong());
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        Optional<Cart> ofResult = Optional.of(cart);
        when(cartRepository.getProductInCart(anyLong(), anyLong(), Mockito.<Cart.OrderStatus>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> customerServiceImpl.updateProductInCart(1L, 1L, false));
        verify(cart).getId();
        verify(cart, atLeast(1)).getProductQuantity();
        verify(cart).setId(eq(1L));
        verify(cart).setOrderStatus(eq(Cart.OrderStatus.NOT_ORDERED));
        verify(cart).setProductId(eq(1L));
        verify(cart).setProductPrice(eq(10.0d));
        verify(cart).setProductQuantity(eq(1L));
        verify(cart).setUserId(eq(1L));
        verify(cartRepository, atLeast(1)).getProductInCart(eq(1L), eq(1L), eq(Cart.OrderStatus.NOT_ORDERED));
    }
}
