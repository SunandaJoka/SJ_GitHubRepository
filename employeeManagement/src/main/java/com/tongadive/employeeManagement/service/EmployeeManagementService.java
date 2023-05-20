package com.tongadive.employeeManagement.service;

import com.tongadive.employeeManagement.entity.Company;
import com.tongadive.employeeManagement.entity.Employee;
import com.tongadive.employeeManagement.model.EmployeeDto;
import com.tongadive.employeeManagement.repository.CompanyRepository;
import com.tongadive.employeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeManagementService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public Employee addEmployee(EmployeeDto employeeDto) {
        Company company= companyRepository.findByCompanyName(employeeDto.getCompanyName());
        Employee entity = new Employee();
        entity.setAge(employeeDto.getAge());
        entity.setCompany(company);
        entity.setEmail(employeeDto.getEmail());
        entity.setGender(employeeDto.getGender());
        entity.setFirstName(employeeDto.getFirstName());
        entity.setLastName(employeeDto.getLastName());
        Employee employee= employeeRepository.save(entity);
        return employee;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesFromCompany(String companyName){
        List<Employee> employeeList= new ArrayList<>();
        Company company= companyRepository.findByCompanyName(companyName);
        employeeList= company.getEmployees();
        return employeeList;
    }
}
