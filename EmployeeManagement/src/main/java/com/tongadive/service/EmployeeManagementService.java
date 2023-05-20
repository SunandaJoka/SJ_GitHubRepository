package com.tongadive.service;

import java.util.List;

import com.tongadive.entity.Company;
import com.tongadive.entity.Employee;

public interface EmployeeManagementService {
	
	Company addCompany(Company company);
	
	Employee addEmployee(Employee employee);
	
	List<Company> getAllCompanies();
	
	List<Employee> getAllEmployeesByCompany(String companyName);

}
