package com.unt.se.ppms.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="one_time_passcode")
public class OneTimePasscode {
	
	@Id
	private int id;
	
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

	public OneTimePasscode(int id, long otp, LocalDateTime generatedTime, User user) {
		super();
		this.id = id;
		this.otp = otp;
		this.generatedTime = generatedTime;
		this.user = user;
	}


	@Override
	public String toString() {
		return "OneTimePasscode [id=" + id + ", otp=" + otp + ", generatedTime=" + generatedTime + ", user=" + user
				+ "]";
	}


}
