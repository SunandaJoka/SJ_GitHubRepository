package com.immaginovate.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.immaginovate.entity.Employee;
import com.immaginovate.model.EmployeeModel;
import com.immaginovate.repository.EmployeeRepository;

public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public EmployeeModel getTaxDeduction(int id) {
		EmployeeModel model= new EmployeeModel();
		Optional<Employee> existingEmployee=repository.findById(id);
		if(existingEmployee.isPresent()) {
			Employee emp=existingEmployee.get();
		Date dt=emp.getDoj();
		Calendar cal=Calendar.getInstance();
		cal.setTime(dt);
		int month=cal.get(Calendar.MONTH);
		if(Integer.valueOf(2)>month) {
			
		}
		
		}
		
		
		return model;
		
		
	}
}
