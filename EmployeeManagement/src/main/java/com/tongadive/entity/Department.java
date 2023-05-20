package com.tongadive.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "department")
@IdClass(CompositeKey.class)
public class Department implements Serializable {
	private static final long serialVersionUID = -909206262878526790L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "department_id")
	private int departmentId;
	
	@Column(name = "department_name")
	@NotBlank(message = "Department Name is required")
	private String departmentName;
	
	@Id
	@OneToOne(optional = false, orphanRemoval = true )
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	private int companyId;

	public Department() {		
	}

	public Department(int departmentId, String departmentName, int companyId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.companyId = companyId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}		

}
