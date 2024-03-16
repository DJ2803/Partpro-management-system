package com.unt.se.ppms.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.unt.se.ppms.dto.CartDto;
import com.unt.se.ppms.entities.PaymentInfo;
import com.unt.se.ppms.entities.PaymentInfo.PaymentStatus;
import com.unt.se.ppms.repository.PaymentInfoRepository;
import com.unt.se.ppms.service.PaymentInfoService;

@RestController
@RequestMapping("/ppms/payment")
public class PaymentInfoController {
	
	@Autowired
    private PaymentInfoService paymentInfoService;
	
	@Autowired
    private PaymentInfoRepository paymentInfoRepository;

	@PostMapping("/{userId}/create")
    public ResponseEntity<?> createPayment(@RequestBody CartDto cart, @PathVariable long userId) {
        try {
            Payment payment = paymentInfoService.createPayment(
            		cart.totalAmount,
                //paymentInfoService.totalAmountOfProducts(userId),
                "USD",
                "paypal",
                "sale",
                "Payment description",
                "http://localhost:8080/ppms/payment/"+userId+"/cancel",
                "http://localhost:8080/ppms/payment/"+userId+"/success"
            );
            for (Links link : payment.getLinks()) {
            	System.out.println(link);
                if (link.getRel().equals("approval_url")) {
                	
                    return ResponseEntity.ok(link.getHref());
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error during payment creation: " + e.getMessage());
        }
        return ResponseEntity.badRequest().body("Unable to create payment");
    }
	
	@GetMapping("/{userId}/success")
    public ResponseEntity<?> successPay(@RequestParam("paymentId") String paymentId, 
                                        @RequestParam("PayerID") String payerId, @PathVariable long userId) {
        try {
            Payment payment = paymentInfoService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
            	String currency = payment.getTransactions().get(0).getAmount().getCurrency();
                String totalAmount = payment.getTransactions().get(0).getAmount().getTotal();

                PaymentInfo paymentInfo = paymentInfoRepository.findById(paymentId)
                                          .orElse(new PaymentInfo());

                paymentInfo.setPaymentId(paymentId);
                paymentInfo.setPayerId(payerId);
                paymentInfo.setAmount(Double.parseDouble(totalAmount));
                paymentInfo.setCurrency(currency);
                paymentInfo.setPaymentStatus(PaymentStatus.SUCCESS.getStr());

                paymentInfoService.addOrUpdatePayment(paymentInfo);
                String redirectUrl = "http://localhost:3000/payment-success?paymentId=" + paymentId + "&status=success";
                return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(redirectUrl)).build();
               // return ResponseEntity.ok("Payment successful. ID: " + paymentId);
            } else {
                return ResponseEntity.unprocessableEntity().body("Payment execution failed. State: " + payment.getState());
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error during payment execution: " + e.getMessage());
        }
    }


    @GetMapping("/{userId}/cancel")
    public ResponseEntity<?> cancelPayment( @PathVariable long userId ) {
        // Assuming paymentId is passed as a query parameter
        try {
            PaymentInfo paymentInfo = new PaymentInfo();
           paymentInfo.setPaymentId(UUID.randomUUID().toString());
           paymentInfo.setPayerId("EVYULUZWTXRC2");
           paymentInfo.setCurrency("USD");
            if (paymentInfo != null) {
                paymentInfo.setPaymentStatus(PaymentStatus.CANCELLED.getStr());
                paymentInfoService.addOrUpdatePayment(paymentInfo);  
            }
            String redirectUrl = "http://localhost:3000/cart";
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(redirectUrl)).build();
      
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An error occurred while cancelling the payment");
        }
    }

}
