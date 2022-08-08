package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            return employee.get();
        }else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee,Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(
                saveEmployee(employee)); //if the existing employee doesn't exist, make a new one.

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        //save existing employee to DataBase
        employeeRepository.save(existingEmployee);
        System.out.println("update!");
        return  existingEmployee;
    }

    @Override
    public Employee deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));

        employeeRepository.delete(employee);
        return employee;
    }
    @Override
    public void deleteEmployees() {
        employeeRepository.deleteAll();
    }

    @Override
    public List<Employee> generateEmployees(int amount) {
        List<Employee> generatedEmployees = new ArrayList<>();
        Faker faker = new Faker(new Locale("en-US"));

        for(int i = 0; i < amount ; i++){
            Employee employee = new Employee();
            employee.setFirstName(faker.name().firstName());
            employee.setLastName(faker.name().lastName());
            employee.setEmail(faker.internet().emailAddress());
            generatedEmployees.add(employee);

        }
        return employeeRepository.saveAll(generatedEmployees);

    }
}
