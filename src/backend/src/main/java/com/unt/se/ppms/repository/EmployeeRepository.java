package com.unt.se.ppms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.unt.se.ppms.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT e FROM Employee e WHERE e.userName = :username")
	Employee getEmployeeByUserName(String username); 
	
	@Query("SELECT e FROM Employee e WHERE e.employeeType = 'assistant_employee'")
    List<Employee> findAllAssistants();
}
