package com.unt.se.ppms.service.impl;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.unt.se.ppms.entities.*;
import com.unt.se.ppms.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentInfoServiceImplTest {

    @Mock
    private PaymentInfoRepository paymentInfoRepository;

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private PaymentInfoServiceImpl paymentInfoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePayment() throws PayPalRESTException {
        // Mocking values
        Double total = 100.0;
        String currency = "USD";
        String method = "paypal";
        String intent = "sale";
        String description = "Test payment";
        String cancelUrl = "http://example.com/cancel";
        String successUrl = "http://example.com/success";

        // Mocking
        Payment payment = mock(Payment.class);
        when(payment.create((String) any())).thenReturn(payment);

        // Test
        assertEquals(payment, paymentInfoService.createPayment(total, currency, method, intent, description, cancelUrl, successUrl));
    }

    @Test
    void testExecutePayment() throws PayPalRESTException {
        // Mocking values
        String paymentId = "PAY-123456789";
        String payerId = "payerId123";

        // Mocking
        Payment payment = mock(Payment.class);
        when(payment.execute((String) any(), any())).thenReturn(payment);

        // Test
        assertEquals(payment, paymentInfoService.executePayment(paymentId, payerId));
    }

    @Test
    void testSavePaymentInfo() {
        PaymentInfo paymentInfo = new PaymentInfo();
        doNothing().when(paymentInfoRepository).save(paymentInfo);

        // Test
        assertDoesNotThrow(() -> paymentInfoService.savePaymentInfo(paymentInfo));
    }

    @Test
    void testTotalAmountOfProducts() {
        long userId = 1L;
        List<Cart> items = Arrays.asList(new Cart(),new Cart());
        when(cartRepository.getAllProductsInCart(userId, Cart.OrderStatus.NOT_ORDERED)).thenReturn(items);

        // Test
        assertEquals(550.0, paymentInfoService.totalAmountOfProducts(userId));
    }

    @Test
    void testAddOrUpdatePayment() {
        PaymentInfo paymentInfo = new PaymentInfo();
        when(paymentInfoRepository.save(paymentInfo)).thenReturn(paymentInfo);

        // Test
        assertEquals("Payment added successfully", paymentInfoService.addOrUpdatePayment(paymentInfo));
    }

    @Test
    void testGetByPaymentId() {
        String paymentId = "PAY-123456789";
        PaymentInfo paymentInfo = new PaymentInfo();
        when(paymentInfoRepository.findById(paymentId)).thenReturn(Optional.of(paymentInfo));

        // Test
        assertEquals(paymentInfo, paymentInfoService.getByPaymentId(paymentId));
    }
}
