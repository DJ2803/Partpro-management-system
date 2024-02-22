package com.unt.se.ppms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.unt.se.ppms.entities.PaymentInfo;
import com.unt.se.ppms.repository.PaymentInfoRepository;
import com.unt.se.ppms.service.PaymentInfoService;

@RestController
@RequestMapping("/ppms/payment")
public class PaymentInfoController {
	
	@Autowired
    private PaymentInfoService paymentInfoService;
	
	@Autowired
    private PaymentInfoRepository paymentInfoRepository;

	@PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentInfo paymentInfo) {
        try {
            Payment payment = paymentInfoService.createPayment(
                paymentInfo.getAmount(),
                paymentInfo.getCurrency(),
                "paypal",
                "sale",
                "Payment description",
                "http://localhost:8080/ppms/payment/cancel",
                "http://localhost:8080/ppms/payment/success"
            );
            for (Links link : payment.getLinks()) {
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
	
	@GetMapping("/success")
    public ResponseEntity<?> successPay(@RequestParam("paymentId") String paymentId, 
                                        @RequestParam("PayerID") String payerId) {
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
                paymentInfo.setStatus("success");

                paymentInfoRepository.save(paymentInfo);

                return ResponseEntity.ok("Payment successful. ID: " + paymentId);
            } else {
                return ResponseEntity.unprocessableEntity().body("Payment execution failed. State: " + payment.getState());
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error during payment execution: " + e.getMessage());
        }
    }


    @GetMapping("/cancel")
    public ResponseEntity<?> cancelPayment(@RequestParam("paymentId") String paymentId) {
        // Assuming paymentId is passed as a query parameter
        try {
            PaymentInfo paymentInfo = paymentInfoRepository.findByPaymentId(paymentId);
            if (paymentInfo != null) {
                paymentInfo.setStatus("cancelled");
                paymentInfoRepository.save(paymentInfo);
                return ResponseEntity.ok("Payment cancelled");
            } else {
                return ResponseEntity.badRequest().body("Invalid payment ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An error occurred while cancelling the payment");
        }
    }

}
