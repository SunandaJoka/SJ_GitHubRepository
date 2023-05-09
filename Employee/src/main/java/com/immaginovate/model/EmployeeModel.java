package com.immaginovate.model;

public class EmployeeModel {
	
	private int id;
	private String firstName;
	private String lastName;
	private double yrlySalary;
	private double taxAmnt;
	private double cessAmnt;
	
	public EmployeeModel() {		
	}
	
	public EmployeeModel(int id, String firstName, String lastName, double yrlySalary, double taxAmnt,
			double cessAmnt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yrlySalary = yrlySalary;
		this.taxAmnt = taxAmnt;
		this.cessAmnt = cessAmnt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getYrlySalary() {
		return yrlySalary;
	}

	public void setYrlySalary(double yrlySalary) {
		this.yrlySalary = yrlySalary;
	}

	public double getTaxAmnt() {
		return taxAmnt;
	}

	public void setTaxAmnt(double taxAmnt) {
		this.taxAmnt = taxAmnt;
	}

	public double getCessAmnt() {
		return cessAmnt;
	}

	public void setCessAmnt(double cessAmnt) {
		this.cessAmnt = cessAmnt;
	}
	
		
	
}
