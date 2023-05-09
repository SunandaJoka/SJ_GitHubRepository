package com.immaginovate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.immaginovate.entity.Employee;
import com.immaginovate.model.EmployeeModel;
import com.immaginovate.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee) {
		service.addEmployee(employee);
		return ResponseEntity.ok("Employee is valid");
	}
	
	@GetMapping("/taxDeduction/{id}")
	public EmployeeModel getTaxDeductionById(@PathVariable int id){			
		return service.getTaxDeduction(id);
		
	}

}
