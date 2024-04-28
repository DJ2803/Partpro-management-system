package com.unt.se.ppms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unt.se.ppms.entities.Cart;
import com.unt.se.ppms.entities.Customer;
import com.unt.se.ppms.entities.Feedback;
import com.unt.se.ppms.exceptions.CustomerNotFoundException;
import com.unt.se.ppms.service.CustomerService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;
@ContextConfiguration(classes = {CustomerController.class})
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CustomerController.class)
@DisabledInAotMode
class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerService customerService;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testAddOrUpdateFeedback() throws Exception {
        // Arrange
        Long userId = 1L;
        Long productId = 1L;
        float rating = 4.5f;
        String expectedResponse = "Feedback updated successfully";

        when(customerService.addOrUpdateFeedback(productId, rating)).thenReturn(expectedResponse);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/ppms/customer/{userId}/addorUpdateFeedback", userId)
                .param("productId", productId.toString())
                .param("rating", String.valueOf(rating))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }
    
    @Test
    public void testViewFeedback() throws Exception {
        // Arrange
        long userId = 1L;  
        long productId = 1L; 
        Feedback expectedFeedback = new Feedback();  
        expectedFeedback.setRating(5);  
  
        when(customerService.viewFeedback(productId)).thenReturn(expectedFeedback);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/ppms/customer/{userId}/viewFeedback/{productID}", userId, productId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rating").value(expectedFeedback.getRating()));
         
    }
    
    
    @Test
    public void testViewFeedbackWhenException() throws Exception {
        // Arrange
        long userId = 1L;
        long productId = 1L;

        when(customerService.viewFeedback(productId)).thenThrow(new RuntimeException("Unexpected error"));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/ppms/customer/{userId}/viewFeedback/{productID}", userId, productId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    /**
     * Method under test:
     * {@link CustomerController#updateCustomerDetails(int, Customer)}
     */
    @Test
    void testUpdateCustomerDetails() throws CustomerNotFoundException {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange and Act
        ResponseEntity<String> actualUpdateCustomerDetailsResult = (new CustomerController()).updateCustomerDetails(1,
                mock(Customer.class));

        // Assert
        assertEquals("Cannot invoke \"com.unt.se.ppms.service.CustomerService.updateCustomer(int, com.unt.se.ppms.entities"
                + ".Customer)\" because \"this.customerService\" is null", actualUpdateCustomerDetailsResult.getBody());
        assertEquals(400, actualUpdateCustomerDetailsResult.getStatusCodeValue());
        assertTrue(actualUpdateCustomerDetailsResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link CustomerController#addProductToCart(long, Cart)}
     */
    @Test
    void testAddProductToCart() throws Exception {
        // Arrange
        when(customerService.addProductToCart(Mockito.<Cart>any())).thenReturn("Add Product To Cart");

        Cart cart = new Cart();
        cart.setId(1L);
        cart.setOrderStatus(Cart.OrderStatus.NOT_ORDERED);
        cart.setProductId(1L);
        cart.setProductPrice(10.0d);
        cart.setProductQuantity(1L);
        cart.setUserId(1L);
        String content = (new ObjectMapper()).writeValueAsString(cart);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/ppms/customer/{userId}/cart/addproduct", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Add Product To Cart"));
    }

    /**
     * Method under test:
     * {@link CustomerController#updateProductInCart(long, long, boolean)}
     */
    @Test
    void testUpdateProductInCart() throws Exception {
        // Arrange
        when(customerService.updateProductInCart(anyLong(), anyLong(), anyBoolean())).thenReturn("2020-03-01");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/ppms/customer/{userId}/cart/update/{productId}/{flag}", 1L, 1L, true);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("2020-03-01"));
    }

    /**
     * Method under test: {@link CustomerController#viewProductsInCart(long)}
     */
    @Test
    void testViewProductsInCart() throws Exception {
        // Arrange
        when(customerService.viewProductsInCart(anyLong())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/ppms/customer/{userId}/cart/viewproducts", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CustomerController#viewOrderedProducts(long)}
     */
    @Test
    void testViewOrderedProducts() throws Exception {
        // Arrange
        when(customerService.viewOrderedProducts(anyLong())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/ppms/customer/{userId}/cart/vieworderedproducts", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link CustomerController#removeProductFromCart(long, long)}
     */
    @Test
    void testRemoveProductFromCart() throws Exception {
        // Arrange
        when(customerService.removeProductFromCart(anyLong(), anyLong())).thenReturn("jane.doe@example.org");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/ppms/customer/{userId}/cart/remove/{productId}", 1L, 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("jane.doe@example.org"));
    }
}
