package com.unt.se.ppms.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PaymentInfoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PaymentInfo#PaymentInfo()}
     *   <li>{@link PaymentInfo#setAmount(Double)}
     *   <li>{@link PaymentInfo#setCurrency(String)}
     *   <li>{@link PaymentInfo#setPayerId(String)}
     *   <li>{@link PaymentInfo#setPaymentId(String)}
     *   <li>{@link PaymentInfo#setPaymentStatus(PaymentInfo.PaymentStatus)}
     *   <li>{@link PaymentInfo#getAmount()}
     *   <li>{@link PaymentInfo#getCurrency()}
     *   <li>{@link PaymentInfo#getPayerId()}
     *   <li>{@link PaymentInfo#getPaymentId()}
     *   <li>{@link PaymentInfo#getPaymentStatus()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        PaymentInfo actualPaymentInfo = new PaymentInfo();
        actualPaymentInfo.setAmount(10.0d);
        actualPaymentInfo.setCurrency("GBP");
        actualPaymentInfo.setPayerId("42");
        actualPaymentInfo.setPaymentId("42");
        actualPaymentInfo.setPaymentStatus(PaymentInfo.PaymentStatus.INITIAL.getStr());
        Double actualAmount = actualPaymentInfo.getAmount();
        String actualCurrency = actualPaymentInfo.getCurrency();
        String actualPayerId = actualPaymentInfo.getPayerId();
        String actualPaymentId = actualPaymentInfo.getPaymentId();
      String actualPaymentStatus = actualPaymentInfo.getPaymentStatus();
        // Assert that nothing has changed
        assertEquals("42", actualPayerId);
        assertEquals("42", actualPaymentId);
        assertEquals("GBP", actualCurrency);
        assertEquals(10.0d, actualAmount.doubleValue());
        assertEquals(PaymentInfo.PaymentStatus.INITIAL.getStr(), actualPaymentStatus);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PaymentInfo#PaymentInfo(Double, String)}
     *   <li>{@link PaymentInfo#setAmount(Double)}
     *   <li>{@link PaymentInfo#setCurrency(String)}
     *   <li>{@link PaymentInfo#setPayerId(String)}
     *   <li>{@link PaymentInfo#setPaymentId(String)}
     *   <li>{@link PaymentInfo#setPaymentStatus(PaymentInfo.PaymentStatus)}
     *   <li>{@link PaymentInfo#getAmount()}
     *   <li>{@link PaymentInfo#getCurrency()}
     *   <li>{@link PaymentInfo#getPayerId()}
     *   <li>{@link PaymentInfo#getPaymentId()}
     *   <li>{@link PaymentInfo#getPaymentStatus()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        PaymentInfo actualPaymentInfo = new PaymentInfo(10.0d, "GBP");
        actualPaymentInfo.setAmount(10.0d);
        actualPaymentInfo.setCurrency("GBP");
        actualPaymentInfo.setPayerId("42");
        actualPaymentInfo.setPaymentId("42");
        actualPaymentInfo.setPaymentStatus(PaymentInfo.PaymentStatus.INITIAL.getStr());
        Double actualAmount = actualPaymentInfo.getAmount();
        String actualCurrency = actualPaymentInfo.getCurrency();
        String actualPayerId = actualPaymentInfo.getPayerId();
        String actualPaymentId = actualPaymentInfo.getPaymentId();
        String actualPaymentStatus = actualPaymentInfo.getPaymentStatus();

        // Assert that nothing has changed
        assertEquals("42", actualPayerId);
        assertEquals("42", actualPaymentId);
        assertEquals("GBP", actualCurrency);
        assertEquals(10.0d, actualAmount.doubleValue());
        assertEquals(PaymentInfo.PaymentStatus.INITIAL.getStr(), actualPaymentStatus);
    }
}
