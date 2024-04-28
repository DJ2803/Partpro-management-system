package com.unt.se.ppms.controller;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unt.se.ppms.dto.SalesDTO;
import com.unt.se.ppms.dto.UserData;
import com.unt.se.ppms.entities.Customer;
import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.entities.OneTimePasscode;
import com.unt.se.ppms.entities.User;
import com.unt.se.ppms.service.LoginService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {LoginController.class})
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = LoginController.class)
@DisabledInAotMode
class LoginControllerTest {
    @Autowired
    private LoginController loginController;

    @MockBean
    private LoginService loginService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private MockMvc mockMvc;

    /**
     * Method under test: {@link LoginController#changePassword(String, String)}
     */
    @Test
    void testChangePassword() throws Exception {
        // Arrange
        when(loginService.changePassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn("iloveyou");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/ppms/user/changepassword/{username}/{newPassword}", "janedoe", "iloveyou");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("iloveyou"));
    }

    /**
     * Method under test: {@link LoginController#generateAndSaveOtp(int)}
     */
    @Test
    void testGenerateAndSaveOtp() throws Exception {
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

        OneTimePasscode oneTimePasscode = new OneTimePasscode();
        oneTimePasscode.setGeneratedTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        oneTimePasscode.setId(1);
        oneTimePasscode.setOtp(1L);
        oneTimePasscode.setUser(user4);
        when(loginService.generateAndSaveOtp(anyInt())).thenReturn(oneTimePasscode);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/ppms/user/resendotp/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"otp\":1,\"generatedTime\":[1970,1,1,0,0],\"user\":{\"userId\":1,\"userName\":\"janedoe\",\"password\":"
                                        + "\"iloveyou\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\":\"42\",\"gender\":\"Gender\",\"mobileNumber\":1,"
                                        + "\"zipcode\":1,\"typeOfUser\":\"Type Of User\"}}"));
    }

    /**
     * Method under test: {@link LoginController#getUserById(int)}
     */
    @Test
    void testGetUserById() throws Exception {
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

        User user13 = new User();
        user13.setCustomer(customer2);
        user13.setEmailId("42");
        user13.setEmployee(employee3);
        user13.setFirstName("Jane");
        user13.setGender("Gender");
        user13.setLastName("Doe");
        user13.setMobileNumber(1L);
        user13.setOtp(otp4);
        user13.setPassword("iloveyou");
        user13.setTypeOfUser("Type Of User");
        user13.setUserId(1);
        user13.setUserName("janedoe");
        user13.setZipcode(1L);
        when(loginService.getUserById(anyInt())).thenReturn(user13);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ppms/user/getuser/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":1,\"userName\":\"janedoe\",\"password\":\"iloveyou\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"emailId\""
                                        + ":\"42\",\"gender\":\"Gender\",\"mobileNumber\":1,\"zipcode\":1,\"typeOfUser\":\"Type Of User\"}"));
    }

    /**
     * Method under test: {@link LoginController#loginFirstStep(String, String)}
     */
    @Test
    void testLoginFirstStep() throws Exception {
        // Arrange
        UserData userData = new UserData();
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
        when(loginService.loginUserFirstStep(Mockito.<String>any(), Mockito.<String>any())).thenReturn(userData);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/ppms/user/login/{username}/{password}",
                "janedoe", "iloveyou");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"userId\":1,\"userName\":\"janedoe\",\"password\":\"iloveyou\",\"emailId\":\"42\",\"mobileNumber\":1,\"zipcode\""
                                        + ":1,\"typeOfUser\":\"Type Of User\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"message\":\"Not all who wander"
                                        + " are lost\"}"));
    }

    /**
     * Method under test: {@link LoginController#loginSecondStep(int, long)}
     */
    @Test
    void testLoginSecondStep() throws Exception {
        // Arrange
        when(loginService.loginUserSecondStep(anyInt(), anyLong())).thenReturn("Login User Second Step");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/ppms/user/login/{id}/verifyotp/{otp}",
                1, 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Login User Second Step"));
    }
    
    @Test
    public void testCompleteAuthenticationFlow() throws Exception {
        // Step 1: Signup
        User newUser = new User(0, "newuser", "newuser@example.com", "password123", null, null, null, 0, 0, null);
        UserData data = new UserData();
        data.setEmailId("newuser@example.com");
        data.setPassword("password123");
        data.setUserName("newuser");
        mockMvc.perform(MockMvcRequestBuilders.post("/ppms/user/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content( objectMapper.writeValueAsString(newUser)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        
        // Step 2: Login First Step
        mockMvc.perform(MockMvcRequestBuilders.post("/ppms/user/login/{username}/{password}", "newuser", "password123"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // Assuming a mechanism to fetch or mock the OTP value here
        long otp = 123456; // Example OTP value

        // Step 3: Login Second Step
        int userId = 1; // Example user ID, this should be fetched or mocked based on the actual response
        when(loginService.loginUserSecondStep(userId,otp)).thenReturn("Login successful");
        mockMvc.perform(MockMvcRequestBuilders.post("/ppms/user/login/{id}/verifyotp/{otp}", userId, otp))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Login successful"));
    }
}
