package com.unt.se.ppms.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employer")
public class Employer {

	@Id
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name = "username")
	private String userName;
	
	@Column
	@Size(min = 8,message = "Password should contain atleast 8 characters")
	private String password;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "dateofbirth")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Column
	private String gender;
	
	@Column(name = "mobileno")
	private long mobileNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "employer_location",
        joinColumns = @JoinColumn(name = "employer_id"),
        inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<Location> locations = new HashSet<>();	

	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OnlineSales> onlineSales = new ArrayList<>();

	
	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employer(int employerId, String userName,
			@Size(min = 8, message = "Password should contain atleast 8 characters") String password, String firstName,
			String lastName, String emailId, LocalDate dob, String gender, long mobileNumber, User user) {
		super();
		this.employerId = employerId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.user = user;
	}


	public int getEmployerId() {
		return employerId;
	}



	public void setEmployerId(int employerId) {
		this.employerId = employerId;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Set<Location> getLocations() {
		return locations;
	}



	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}



	public List<OnlineSales> getOnlineSales() {
		return onlineSales;
	}



	public void setOnlineSales(List<OnlineSales> onlineSales) {
		this.onlineSales = onlineSales;
	}



	@Override
	public String toString() {
		return "Employer [employerId=" + employerId + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", dob=" + dob + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	
}
