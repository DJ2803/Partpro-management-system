package com.unt.se.ppms.service.impl;

import com.unt.se.ppms.entities.Employee;
import com.unt.se.ppms.exceptions.EmployeeNotFoundException;
import com.unt.se.ppms.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateEmployee_Success() {
        Employee employee = new Employee();
        employee.setEmployeeId(1000);

        when(employeeRepository.save(employee)).thenReturn(employee);

        assertDoesNotThrow(() -> employeeService.updateEmployee(employee));
    }

    @Test
    void testUpdateEmployee_ThrowsException() {
        Employee employee = new Employee();
        employee.setEmployeeId(1001);

        when(employeeRepository.save(employee)).thenThrow(new RuntimeException());

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.updateEmployee(employee));
    }
}