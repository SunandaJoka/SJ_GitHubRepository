package com.tongadive.entity;

import java.io.Serializable;
import java.util.Objects;

public class CompositeKey implements Serializable {
	
	private static final long serialVersionUID = -909206262878526790L;
	
	private int departmentId;
	private Company company;
	
	public CompositeKey() {		
	}
	
	public CompositeKey(int departmentId, Company company) {
		super();
		this.departmentId = departmentId;
		this.company = company;
	}

	@Override
	public int hashCode() {
		return Objects.hash(company, departmentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKey other = (CompositeKey) obj;
		return Objects.equals(company, other.company) && departmentId == other.departmentId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
