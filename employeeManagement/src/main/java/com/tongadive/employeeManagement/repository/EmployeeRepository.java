package com.tongadive.employeeManagement.repository;

import com.tongadive.employeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
