package com.unt.se.ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unt.se.ppms.entities.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
	
}

