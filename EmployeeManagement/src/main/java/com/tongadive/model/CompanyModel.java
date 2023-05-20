package com.tongadive.model;

public class CompanyModel {
	
	private int companyId;
	private String companyName;
	
	public CompanyModel() {		
	}	
	
	public CompanyModel(int companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	

}
