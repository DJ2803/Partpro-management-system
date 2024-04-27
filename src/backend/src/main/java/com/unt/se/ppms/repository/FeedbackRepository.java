package com.unt.se.ppms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unt.se.ppms.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
	
	Feedback getFeedbackByProductID(long productId);

}
