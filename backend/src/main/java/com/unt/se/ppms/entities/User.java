package com.unt.se.ppms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "myschema", uniqueConstraints = {
	    @UniqueConstraint(columnNames = {"username"}),
	    @UniqueConstraint(columnNames = {"email_id"})
	})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public int userId;
	
	@Column(name = "username")
	public String userName;
	
	@Column
	@Size(min = 8,message = "Password should contain atleast 8 characters")
	public String password;
	
	@Column(name = "firstname")
	public String firstName;
	
	@Column(name = "lastname")
	public String lastName;
	
	@Column(name = "email_id")
	public String emailId;
	
	@Column
	private String gender;
	
	@Column(name = "mobileno")
	private long mobileNumber;
	
	@Column(name = "zipcode")
	private long zipcode;
	
	@Column(name = "type_of_user")
	public String typeOfUser;
	
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Customer customer;
	
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Employee employee;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private OneTimePasscode otp;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public User(int userId, String userName,
			@Size(min = 8, message = "Password should contain atleast 8 characters") String password, String firstName,
			String lastName, String emailId, String gender, long mobileNumber, long zipcode, String typeOfUser) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.zipcode = zipcode;
		this.typeOfUser = typeOfUser;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", zipcode=" + zipcode + ", typeOfUser=" + typeOfUser + "]";
	}


	public boolean isEmpty() {
		return userName == null || userName.isEmpty() || emailId == null || emailId.isEmpty();
	}

}
