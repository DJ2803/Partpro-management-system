package com.unt.se.ppms.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
import com.unt.se.ppms.dto.OnlineSalesDTO;
import com.unt.se.ppms.dto.SalesDTO;
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
	public static List<Long> productIds = new ArrayList<>();
	@PostMapping("/{userId}/create")
    public ResponseEntity<?> createPayment(@RequestBody CartDto cart, @PathVariable long userId) {
		productIds=cart.getProdIds();
		System.out.println("ids"+productIds);
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
		String productIdsString = productIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
		System.out.println("ids"+productIdsString);
        try {
        	System.out.println("ids"+productIds);
  
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
                paymentInfo.setOrderId(paymentId);
                paymentInfo.setOrderStatus("Pending");
                paymentInfoService.addOrUpdatePayment(paymentInfo);
                SalesDTO dto = new SalesDTO();
                dto.setCustomerID(userId);
                dto.setProductIDString(productIdsString);
                dto.setTotalAmount(Double.parseDouble(totalAmount));
                paymentInfoService.manageOnlineSales(dto);
                String redirectUrl = "http://localhost:3000/payment-success?orderId=" + paymentId + "&orderStatus=Pending" + "&productIds=" + productIdsString;
                return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(redirectUrl)).build();
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
    
    @GetMapping("/trackorderdetails/{trackingId}")
    public ResponseEntity<PaymentInfo> trackOrder(@PathVariable String trackingId){
    	try {
    		PaymentInfo p=paymentInfoService.getByOrderId(trackingId);	
    		return new ResponseEntity<PaymentInfo>(p, HttpStatus.OK); 
    	}
    	catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
		
    }
    
    @PostMapping("/saveorderdetails/{userId}")
    public ResponseEntity<String> manageSales(@PathVariable long userId){
    	try {
    		  SalesDTO dto = new SalesDTO();
              dto.setCustomerID(userId);
              dto.setProductIDString("1,2");
              dto.setTotalAmount(Double.parseDouble("12.56"));
    		String str=paymentInfoService.manageOnlineSales(dto);	
    		return new ResponseEntity<String>(str, HttpStatus.OK); 
    	}
    	catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
		
    }
    
    @GetMapping("/getOnlineSales")
    public ResponseEntity<List<OnlineSalesDTO>> viewSales(){
    	try {
    		List<OnlineSalesDTO> list= paymentInfoService.viewOnlineSales();
    		return new ResponseEntity<List<OnlineSalesDTO>>(list, HttpStatus.OK); 
    	}
    	catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
		
    }

}
