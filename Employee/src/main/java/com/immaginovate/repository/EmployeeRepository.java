package com.immaginovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immaginovate.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
