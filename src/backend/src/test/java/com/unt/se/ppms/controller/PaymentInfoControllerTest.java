package com.unt.se.ppms.controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.unt.se.ppms.entities.PaymentInfo;
import com.unt.se.ppms.repository.PaymentInfoRepository;
import com.unt.se.ppms.service.PaymentInfoService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PaymentInfoController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PaymentInfoControllerTest {
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
}
