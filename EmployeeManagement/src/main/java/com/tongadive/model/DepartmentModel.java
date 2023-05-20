package com.tongadive.model;

public class DepartmentModel {
	
	private int departmentId;
	private String departmentName;
	private int companyId;
	
	public DepartmentModel() {
	}
	
	public DepartmentModel(int departmentId, String departmentName, int companyId) {
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
