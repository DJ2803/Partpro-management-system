package com.unt.se.ppms.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	@Column(name = "dateofbirth")
	@JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate dob;
	
	@Column
	public String gender;
	
	@Column(name = "mobileno")
	public long mobileNumber;
	
	@Column(name = "type_of_user")
	public String typeOfUser;
	
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Customer customer;
	
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Employer employer;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private OneTimePasscode otp;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, String password, String firstName, String lastName, String emailId,
			LocalDate dob, String gender, long mobileNumber, String typeOfUser) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.typeOfUser = typeOfUser;
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public OneTimePasscode getOtp() {
		return otp;
	}

	public void setOtp(OneTimePasscode otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + "********" + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", dob=" + dob + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", typeOfUser=" + typeOfUser + "]";
	}
	
	
	
	
}
