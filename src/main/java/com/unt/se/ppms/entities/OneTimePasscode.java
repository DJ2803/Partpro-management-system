package com.unt.se.ppms.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="one_time_passcode")
public class OneTimePasscode {
	
	@Id
	private int user_id;
	
	@Column
	private long otp;
	
	@Column(name = "generated_time")
	private LocalDateTime generatedTime;
	
	@OneToOne
	@MapsId
	private User user;

	public OneTimePasscode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OneTimePasscode(int user_id, long otp, LocalDateTime generatedTime, User user) {
		super();
		this.user_id = user_id;
		this.otp = otp;
		this.generatedTime = generatedTime;
		this.user = user;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public long getOtp() {
		return otp;
	}

	public void setOtp(long otp) {
		this.otp = otp;
	}

	public LocalDateTime getGeneratedTime() {
		return generatedTime;
	}

	public void setGeneratedTime(LocalDateTime generatedTime) {
		this.generatedTime = generatedTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "OneTimePasscode [user_id=" + user_id + ", otp=" + otp + ", generatedTime=" + generatedTime + ", user="
				+ user + "]";
	}
	
	

}
