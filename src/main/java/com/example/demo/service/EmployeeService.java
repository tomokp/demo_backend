package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee, Long id);

    Employee deleteEmployee(Long id);

    void deleteEmployees();

    List<Employee> generateEmployees(int amount);
}
