package com.unt.se.ppms.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.unt.se.ppms.dto.OnlineSalesDTO;
import com.unt.se.ppms.dto.SalesDTO;
import com.unt.se.ppms.entities.PaymentInfo;
import com.unt.se.ppms.repository.PaymentInfoRepository;
import com.unt.se.ppms.service.PaymentInfoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

@ContextConfiguration(classes = {PaymentInfoController.class})
@ExtendWith(SpringExtension.class)
@WebMvcTest(PaymentInfoController.class)
@DisabledInAotMode
class PaymentInfoControllerTest {
	
	 @Autowired
	 private MockMvc mockMvc;
	  
    @Autowired
    private PaymentInfoController paymentInfoController;

    @MockBean
    private PaymentInfoRepository paymentInfoRepository;

    @MockBean
    private PaymentInfoService paymentInfoService;

    /**
     * Method under test: {@link PaymentInfoController#cancelPayment(String, long)}
     */
    @Test
    void testCancelPayment() throws Exception {
        // Arrange
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setAmount(10.0d);
        paymentInfo.setCurrency("GBP");
        paymentInfo.setPayerId("42");
        paymentInfo.setPaymentId("42");
        paymentInfo.setPaymentStatus(PaymentInfo.PaymentStatus.INITIAL.getStr());
        when(paymentInfoService.addOrUpdatePayment(Mockito.<PaymentInfo>any())).thenReturn("2020-03-01");
        when(paymentInfoService.getByPaymentId(Mockito.<String>any())).thenReturn(paymentInfo);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ppms/payment/{userId}/cancel", 1L)
                .param("paymentId", "foo");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(paymentInfoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost:3000/cart"));
    }

    /**
     * Method under test:
     * {@link PaymentInfoController#createPayment(PaymentInfo, long)}
     */
    @Test
    void testCreatePayment() throws Exception {
        // Arrange
        Payment payment = new Payment();
        payment.setLinks(new ArrayList<>());
        when(paymentInfoService.createPayment(Mockito.<Double>any(), Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn(payment);
        when(paymentInfoService.totalAmountOfProducts(anyLong())).thenReturn(10.0d);

        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setAmount(10.0d);
        paymentInfo.setCurrency("GBP");
        paymentInfo.setPayerId("42");
        paymentInfo.setPaymentId("42");
        paymentInfo.setPaymentStatus(PaymentInfo.PaymentStatus.INITIAL.getStr());
        String content = (new ObjectMapper()).writeValueAsString(paymentInfo);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/ppms/payment/{userId}/create", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(paymentInfoController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Unable to create payment"));
    }

    /**
     * Method under test:
     * {@link PaymentInfoController#createPayment(PaymentInfo, long)}
     */
    @Test
    void testCreatePayment2() throws Exception {
        // Arrange
        when(paymentInfoService.createPayment(Mockito.<Double>any(), Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
                .thenThrow(new PayPalRESTException("An error occurred"));
        when(paymentInfoService.totalAmountOfProducts(anyLong())).thenReturn(10.0d);

        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setAmount(10.0d);
        paymentInfo.setCurrency("GBP");
        paymentInfo.setPayerId("42");
        paymentInfo.setPaymentId("42");
        paymentInfo.setPaymentStatus(PaymentInfo.PaymentStatus.INITIAL.getStr());
        String content = (new ObjectMapper()).writeValueAsString(paymentInfo);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/ppms/payment/{userId}/create", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(paymentInfoController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Error during payment creation: An error occurred"));
    }

    /**
     * Method under test:
     * {@link PaymentInfoController#successPay(String, String, long)}
     */
    @Test
    void testSuccessPay() throws Exception {
        // Arrange
        when(paymentInfoService.executePayment(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new Payment());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/ppms/payment/{userId}/success", "Uri Variables", "Uri Variables")
                .param("PayerID", "foo")
                .param("paymentId", "foo");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(paymentInfoController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test:
     * {@link PaymentInfoController#successPay(String, String, long)}
     */
    @Test
    void testSuccessPay2() throws Exception {
        // Arrange
        Payment payment = new Payment();
        payment.setState("MD");
        when(paymentInfoService.executePayment(Mockito.<String>any(), Mockito.<String>any())).thenReturn(payment);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ppms/payment/{userId}/success", 1L)
                .param("PayerID", "foo")
                .param("paymentId", "foo");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(paymentInfoController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(422))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Payment execution failed. State: MD"));
    }

    /**
     * Method under test:
     * {@link PaymentInfoController#successPay(String, String, long)}
     */
    @Test
    void testSuccessPay3() throws Exception {
        // Arrange
        when(paymentInfoService.executePayment(Mockito.<String>any(), Mockito.<String>any()))
                .thenThrow(new PayPalRESTException("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ppms/payment/{userId}/success", 1L)
                .param("PayerID", "foo")
                .param("paymentId", "foo");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(paymentInfoController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Error during payment execution: An error occurred"));
    }
    
    
    @Test
    public void testTrackOrder() throws Exception {
        // Arrange
        String trackingId = "123";
        PaymentInfo paymentInfo = new PaymentInfo(); // Assuming PaymentInfo is a valid object
        when(paymentInfoService.getByOrderId(trackingId)).thenReturn(paymentInfo);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/ppms/payment/trackorderdetails/{trackingId}", trackingId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(paymentInfo)));
    }
    
    @Test
    public void testViewOnlineSales() throws Exception {
        // Arrange
        OnlineSalesDTO sale1 = new OnlineSalesDTO("Product1", 150, 3);
        OnlineSalesDTO sale2 = new OnlineSalesDTO("Product2", 200, 5);
       List< OnlineSalesDTO> salesList = Arrays.asList(sale1, sale2);

        when(paymentInfoService.viewOnlineSales()).thenReturn(salesList);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/ppms/payment/getOnlineSales")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(salesList)));
    
    }
    
    @Test
    public void testViewOnlineSalesWhenException() throws Exception {
        // Arrange
        when(paymentInfoService.viewOnlineSales()).thenThrow(new RuntimeException("Database failure"));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/ppms/payment/getOnlineSales")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
    
    
    @Test
    public void testManageSales() throws Exception {
        // Arrange
        long userId = 1L;
        String expectedResponse = "Order saved successfully";
        when(paymentInfoService.manageOnlineSales(any(SalesDTO.class))).thenReturn(expectedResponse);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/ppms/payment/saveorderdetails/{userId}", userId)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }

    @Test
    public void testManageSalesWhenException() throws Exception {
        // Arrange
        long userId = 1L;
        when(paymentInfoService.manageOnlineSales(any(SalesDTO.class))).thenThrow(new RuntimeException("Database failure"));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/ppms/payment/saveorderdetails/{userId}", userId)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
    
    
    
    @Test
    void testCompletePaymentAndTrackOrder() throws Exception {
        // Step 1: Simulate a successful payment
        when(paymentInfoService.executePayment(Mockito.anyString(), Mockito.anyString())).thenReturn(new Payment());

        mockMvc.perform(MockMvcRequestBuilders.get("/ppms/payment/{userId}/success", "userIdExample")
                .param("PayerID", "payerExample")
                .param("paymentId", "paymentExample"));

        // Step 2: Track the order after successful payment
        String trackingId = "123";  
        PaymentInfo paymentInfo = new PaymentInfo(); 
        when(paymentInfoService.getByOrderId(trackingId)).thenReturn(paymentInfo);

        mockMvc.perform(MockMvcRequestBuilders.get("/ppms/payment/trackorderdetails/{trackingId}", trackingId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(paymentInfo)));

 
    }
}
