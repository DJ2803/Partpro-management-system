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
	
	@Column(name = "date_of_birth")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
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
        name = "employer_location",
        joinColumns = @JoinColumn(name = "employer_id"),
        inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<Location> locations = new HashSet<>();	

	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OnlineSales> onlineSales = new ArrayList<>();

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public Employee(int employeeId, String employeeName,
			@Size(min = 8, message = "Password should contain atleast 8 characters") String password, String emailId,
			String userName, User user) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.emailId = emailId;
		this.userName = userName;
		this.user = user;
	}




	public Employee(int employeeId, String employeeName,
			@Size(min = 8, message = "Password should contain atleast 8 characters") String password,
			String employeeType, String emailId, LocalDate dob, LocalDate dateOfHire, String gender, long mobileNumber,
			User user, Set<Location> locations, List<OnlineSales> onlineSales) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.employeeType = employeeType;
		this.emailId = emailId;
		this.dob = dob;
		this.dateOfHire = dateOfHire;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.user = user;
		this.locations = locations;
		this.onlineSales = onlineSales;
	}




	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", userName=" + userName
				+ ", password=" + password + ", employeeType=" + employeeType + ", emailId=" + emailId + ", dob=" + dob
				+ ", dateOfHire=" + dateOfHire + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", user="
				+ user + "]";
	}

	
	
	
}
