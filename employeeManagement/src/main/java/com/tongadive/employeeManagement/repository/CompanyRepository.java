package com.tongadive.employeeManagement.repository;

import com.tongadive.employeeManagement.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    public Company findByCompanyName(String companyName);
}
