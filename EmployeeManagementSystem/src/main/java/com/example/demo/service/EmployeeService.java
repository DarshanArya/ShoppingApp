package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Employee;

public interface EmployeeService {
    void save(Employee employee);
    List<Employee> getAll();
	Employee addEmployee(Employee employee);
    
    
}
