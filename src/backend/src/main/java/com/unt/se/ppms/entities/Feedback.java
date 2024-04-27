package com.unt.se.ppms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "feedback_ID")
	private Integer feedbackID;
	
	@Column(name = "product_ID")
	private long productID;
	
	@Column(name ="ratings_count")
	private int ratingsCount;
	
	
	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	@Column(name="rating")
	private float rating;

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Integer getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(Integer feedbackID) {
		this.feedbackID = feedbackID;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}
	
	public Feedback() {
		
	}

	public Feedback(Integer feedbackID, long productID, float rating, int ratingsCount ) {
		super();
		this.feedbackID = feedbackID;
		this.productID = productID;
		this.rating = rating;
		this.ratingsCount=ratingsCount;
	}
	
	
}
