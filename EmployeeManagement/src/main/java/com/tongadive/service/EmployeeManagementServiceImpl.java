package com.tongadive.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tongadive.entity.Company;
import com.tongadive.entity.Employee;
import com.tongadive.repository.CompanyRepository;
import com.tongadive.repository.EmployeeRepository;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService{

	@Autowired
	private CompanyRepository companyRepository;	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeManagementServiceImpl(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
		super();
		this.companyRepository = companyRepository;
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Company addCompany(Company company) {		
		return companyRepository.save(company);
	}

	@Override
	public Employee addEmployee(Employee employee) {				
		return employeeRepository.save(employee);
	}

	@Override
	public List<Company> getAllCompanies() {
		List<Company> companiesList=companyRepository.findAll();
		return companiesList;
	}

	@Override
	public List<Employee> getAllEmployeesByCompany(String companyName) {
		List<Employee> employeeList = employeeRepository.findAll();
		List<Employee> empListByCompany = employeeList.stream()
														.filter(e -> e.getDepartment().getDepartmentName().equalsIgnoreCase(companyName))
														.collect(Collectors.toList());
		return empListByCompany;
	}

}
