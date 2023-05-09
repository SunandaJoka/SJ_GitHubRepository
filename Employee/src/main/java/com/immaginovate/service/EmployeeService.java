package com.immaginovate.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
		int salariedMonths;
		if(Integer.valueOf(2)>month) {
			salariedMonths= (11-month) +3;
		}else {
			salariedMonths=month-2;
		}
		int salariedDays=0;
		double salaryPerDay=(emp.getSalary()/30);
		int date= cal.get(Calendar.DAY_OF_MONTH);
		Calendar tempCal= new GregorianCalendar(Calendar.YEAR, month, 1);
		int daysInMonth= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH);
		salariedDays= daysInMonth-date;
		
		double totalSal=(salariedMonths*emp.getSalary())+(salariedDays*(emp.getSalary()/salaryPerDay));
				
		model.setId(emp.getId());
		model.setFirstName(emp.getFirstName());
		model.setLastName(emp.getLastName());
		model.setYrlySalary(totalSal);
		if(totalSal>2500000) {
			model.setCessAmnt((totalSal-2500000)*0.02);
		}else {
			model.setCessAmnt(0.0d);
		}
		if(totalSal<250000 || totalSal==250000) {
			model.setTaxAmnt(0.0d);
		}else if(totalSal<500000 || totalSal==500000){
			model.setTaxAmnt((totalSal-250000)*0.05);
		}else if(totalSal<1000000 || totalSal==1000000) {
			model.setTaxAmnt((250000*0.05)+((totalSal-500000)*0.1));
		}else if(totalSal>1000000) {
			model.setTaxAmnt((250000*0.05)+(500000*0.1)+((totalSal-1000000)*0.2));
		}		
		
		}
		
		
		return model;
				
	}

	
}
