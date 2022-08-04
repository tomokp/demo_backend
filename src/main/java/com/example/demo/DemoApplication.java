package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Locale;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private EmployeeService employeeService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			int max = 10;
			Faker faker = new Faker(new Locale("en-US"));

			for(int i = 0; i < max ; i++){
				Employee employee = new Employee();
				employee.setFirstName(faker.name().firstName());
				employee.setLastName(faker.name().lastName());
				employee.setEmail(faker.internet().safeEmailAddress());
				employeeService.saveEmployee(employee);
			}
		};
	}

}
