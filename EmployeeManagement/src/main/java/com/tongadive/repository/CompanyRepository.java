package com.tongadive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tongadive.entity.Company;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Integer> {

}
