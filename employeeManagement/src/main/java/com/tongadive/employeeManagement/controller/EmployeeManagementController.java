package com.tongadive.employeeManagement.controller;

import com.tongadive.employeeManagement.entity.Company;
import com.tongadive.employeeManagement.entity.Employee;
import com.tongadive.employeeManagement.exception.CompanyNotFoundError;
import com.tongadive.employeeManagement.model.EmployeeDto;
import com.tongadive.employeeManagement.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/employee-management")
public class EmployeeManagementController {

    @Autowired
    EmployeeManagementService employeeManagementService;

    //Build Add Company REST API
    //http://localhost:8080/api/employee-management/company
    @PostMapping(path = "/company")
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        return new ResponseEntity<>(employeeManagementService.addCompany(company), HttpStatus.CREATED);
    }

    //Build Add Employee REST API
    //http://localhost:8080/api/employee-management/employee
    @PostMapping(path = "/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeManagementService.addEmployee(employeeDto), HttpStatus.CREATED);
    }        
    
    //Build Get All Companies REST API
    //http://localhost:8080/api/employee-management/companies
    @GetMapping(path = "/companies")
    public ResponseEntity<List<Company>> getCompanies(){
        return new ResponseEntity<>(employeeManagementService.getCompanies(), HttpStatus.OK);
    }

    //Build GetEmployees By Company REST API
    //http://localhost:8080/api/employee-management/employees-of-company/{}
    @GetMapping(path = "/employees-of-company/{companyName}")
    public HttpEntity<? extends Object> getEmployees(@PathVariable String companyName) {
        try{
            return new ResponseEntity<>(employeeManagementService.getEmployeesFromCompany(companyName), HttpStatus.OK);
        }catch (Exception ex){
            CompanyNotFoundError apiError =
                    new CompanyNotFoundError(HttpStatus.BAD_REQUEST, "Company with name "+companyName+ " does not exists");
            return new ResponseEntity<Object>(
                    apiError, new HttpHeaders(), apiError.getStatus());
        }
    }
}
