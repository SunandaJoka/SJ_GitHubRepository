package com.tongadive.entity;

import java.io.Serializable;
import java.util.Objects;

public class CompositeKey implements Serializable {
	
	private static final long serialVersionUID = -909206262878526790L;
	
	private int departmentId;
	private int companyId;
	
	public CompositeKey() {		
	}
	
	public CompositeKey(int departmentId, int companyId) {
		super();
		this.departmentId = departmentId;
		this.companyId = companyId;
	}


	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyId, departmentId);
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
		return companyId == other.companyId && departmentId == other.departmentId;
	}

}
