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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "username")
	public String userName;
	
	@Column
	@Size(min = 8,message = "Password should contain atleast 8 characters")
	private String password;
	
	@Column(name = "employee_type")
	private String employeeType;
	
	@Column(name = "email_id")
	private String emailId;
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}




	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}




	public String getEmployeeName() {
		return employeeName;
	}




	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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




	public String getEmployeeType() {
		return employeeType;
	}




	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}




	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}








	public LocalDate getDateOfHire() {
		return dateOfHire;
	}




	public void setDateOfHire(LocalDate dateOfHire) {
		this.dateOfHire = dateOfHire;
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




	public long getSalary() {
		return salary;
	}




	public void setSalary(long salary) {
		this.salary = salary;
	}




	public String getDesignation() {
		return designation;
	}




	public void setDesignation(String designation) {
		this.designation = designation;
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




	@Column(name = "date_of_hire")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfHire;
	
	@Column
	private String gender;
	
	@Column(name = "mobileno")
	private long mobileNumber;
	
	@Column(name = "salary")
	private long salary;
	
	@Column(name = "designation")
	private String designation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "employee_location",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<Location> locations = new HashSet<>();	

	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OnlineSales> onlineSales = new ArrayList<>();

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Employee(int employeeId, String username,
			@Size(min = 8, message = "Password should contain atleast 8 characters") String password, String fullName,
			String emailId, String gender,long mobileNumber, User user) {
		super();
		this.employeeId = employeeId;
		this.userName = username;
		this.password = password;
		this.employeeName = fullName;
		this.emailId = emailId;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.user=user;
	}








	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", userName=" + userName
				+ ", password=" + password + ", employeeType=" + employeeType + ", emailId=" + emailId + ", dateOfHire="
				+ dateOfHire + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", salary=" + salary
				+ ", designation=" + designation + ", user=" + user + ", locations=" + locations + ", onlineSales="
				+ onlineSales + "]";
	}




	

	
	
	
}
