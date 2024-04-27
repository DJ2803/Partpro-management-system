package com.unt.se.ppms.service;

import java.util.List;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.unt.se.ppms.dto.OnlineSalesDTO;
import com.unt.se.ppms.dto.SalesDTO;
import com.unt.se.ppms.entities.PaymentInfo;

public interface PaymentInfoService {
	
	public Payment createPayment(
            Double total, 
            String currency, 
            String method,
            String intent, 
            String description, 
            String cancelUrl, 
            String successUrl) throws PayPalRESTException;
	
	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;
	
	public void savePaymentInfo(PaymentInfo paymentInfo);
	
	public Double totalAmountOfProducts(long userId);
	
	public String addOrUpdatePayment(PaymentInfo paymentInfo);
	
	public PaymentInfo getByPaymentId(String paymentId);
	
	public PaymentInfo getByOrderId(String orderId);

	public String manageOnlineSales(SalesDTO dto);
	
	public List<OnlineSalesDTO>viewOnlineSales();
}
