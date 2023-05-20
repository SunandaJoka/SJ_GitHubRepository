package com.tongadive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tongadive.entity.Company;
import com.tongadive.entity.Employee;
import com.tongadive.service.EmployeeManagementService;

@RestController
@RequestMapping("api/employeeManagement")
public class EmployeeManagementController {
	
	@Autowired
	private EmployeeManagementService employeeManagementService;

	public EmployeeManagementController(EmployeeManagementService employeeManagementService) {
		super();
		this.employeeManagementService = employeeManagementService;
	}
	
	//Build Add Company REST API
	//http://localhost:8080/api/employeeManagement/addCompany
	@PostMapping("/addCompany")
	public ResponseEntity<Company> addCompany(@RequestBody Company company) {
		Company savedCompany = employeeManagementService.addCompany(company);		
		return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);		
	}
	
	//Build Add Employee REST API
	//http://localhost:8080/api/employeeManagement/addEmployee
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee savedEmployee = employeeManagementService.addEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//Build Get All Companies REST API
	//http://localhost:8080/api/employeeManagement/allCompanies
	@GetMapping("/allCompanies")
	public ResponseEntity<List<Company>> getAllCompanies(){
		List<Company> companiesList = employeeManagementService.getAllCompanies();
		return new ResponseEntity<>(companiesList, HttpStatus.OK);		
	}
	
	//Build Get All Employees By Company Name REST API
	//http://localhost:8080/api/employeeManagement/allEmployees/{companyName}
	@GetMapping("allEmployees/{companyName}")
	public ResponseEntity<List<Employee>> getEmployeesByCompany(@PathVariable("companyName") String companyName){
		List<Employee> employeesByCompany = employeeManagementService.getAllEmployeesByCompany(companyName);		
		return new ResponseEntity<>(employeesByCompany, HttpStatus.OK);
		
	}
	
	
	
}