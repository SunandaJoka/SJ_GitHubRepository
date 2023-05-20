package com.tongadive.employeeManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    @Column(name = "company_name")
    @NotBlank(message = "Company Name is Required")
    private String companyName;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees;


    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Company() {
    }
    
    public Integer getCompanyId() {
        return companyId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
