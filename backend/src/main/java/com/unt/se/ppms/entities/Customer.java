package com.unt.se.ppms.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name = "username")
	public String username;
	
	@Column
	@Size(min = 8,message = "Password should contain atleast 8 characters")
	private String password;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "dateofbirth")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Column
	private String gender;
	
	@Column(name = "mobileno")
	private long mobileNumber;
	
	@Column(name = "zipcode")
	private long zipcode;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicles> vehicles = new ArrayList<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OnlineSales> onlineSales = new ArrayList<>();

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int customerId, String username,
			@Size(min = 8, message = "Password should contain atleast 8 characters") String password, String fullName,
			String emailId, String gender,long mobileNumber, long zipcode) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.emailId = emailId;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.zipcode = zipcode;
	}

	public Customer(int customerId, String username,
			@Size(min = 8, message = "Password should contain atleast 8 characters") String password, String fullName,
			String emailId, LocalDate dob, String gender, long mobileNumber, long zipcode) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.emailId = emailId;
		this.dob = dob;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.zipcode = zipcode;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", password=" + password
				+ ", fullName=" + fullName + ", emailId=" + emailId + ", dob=" + dob + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", zipcode=" + zipcode + ", user=" + user + ", vehicles="
				+ vehicles + ", onlineSales=" + onlineSales + "]";
	}

	
	
}
