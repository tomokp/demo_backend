package com.example.demo;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private EmployeeService employeeService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
