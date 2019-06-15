package com.bookstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.domain.Employee;
import com.bookstore.repositories.EmployeeRepository;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

	@Autowired
	EmployeeRepository<Employee> employeeRepository;
	
	@RequestMapping("/login")
	public Employee login(@RequestHeader("username") String username) {
		return employeeRepository.findOne(username);
	}
	
}
