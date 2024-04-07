package com.unt.se.ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unt.se.ppms.entities.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
	
	@Query("SELECT p FROM PaymentInfo p WHERE p.orderId = :orderId")
	PaymentInfo getPaymentInfoByOrderId(String orderId);
}

