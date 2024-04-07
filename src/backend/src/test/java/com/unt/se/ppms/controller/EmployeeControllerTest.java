package com.unt.se.ppms.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unt.se.ppms.dto.EmployeeDTO;
import com.unt.se.ppms.dto.ProductsDTO;
import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.repository.ProductsRepository;
import com.unt.se.ppms.service.EmployeeService;
import com.unt.se.ppms.service.ProductService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
@DisabledInAotMode
class EmployeeControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeController#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee() throws Exception {
        // Arrange
        when(employeeService.updateEmployee(Mockito.<Employee>any())).thenReturn("2020-03-01");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/ppms/employee/update");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }

    /**
     * Method under test: {@link EmployeeController#updateEmployee(Employee)}
     */
    @Test
    void testUpdateEmployee2() throws Exception {
        // Arrange
        when(employeeService.updateEmployee(Mockito.<Employee>any())).thenReturn("2020-03-01");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/ppms/employee/update")
                .param("dateOfHire", "2020-03-01");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }
    
    @Test
    public void testAddOrUpdateProduct() throws Exception {
        // Arrange
        Long productId = 1L;
        Integer quantity = 10;
        String expectedResponse = "Product added or updated successfully";
        when(employeeService.addOrUpdateProduct(productId, quantity)).thenReturn(expectedResponse);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/ppms/employee/addOrUpdateProduct")
                .param("productId", productId.toString())
                .param("quantity", quantity.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }

    
    @Test
    public void testFindByUserName() throws Exception {
        // Arrange
        String userName = "testUser";
        EmployeeDTO employeeDTO = new EmployeeDTO(); // Assume EmployeeDTO is properly set up
        employeeDTO.setDesignation("store_manager");
        when(employeeService.findEmployeeByUserName(userName)).thenReturn(employeeDTO);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/ppms/employee/findByUserName")
                .param("userName", userName)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(employeeDTO)));
    }
    
    @Test
    public void testGetAssistant() throws Exception {
        // Arrange
        EmployeeDTO employeeDTO = new EmployeeDTO(); // Setup EmployeeDTO with expected data
        when(employeeService.findAssistantEmployee()).thenReturn(employeeDTO);
        employeeDTO.setDesignation("assistant_employee");
        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/ppms/employee/getAssistant")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(employeeDTO)));
    }

	
	
}
