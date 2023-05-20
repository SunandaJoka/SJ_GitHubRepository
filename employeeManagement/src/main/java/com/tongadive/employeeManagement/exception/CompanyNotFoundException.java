package com.tongadive.employeeManagement.exception;

public class CompanyNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -909206262878526790L;
	
    public CompanyNotFoundException(String message) {
        super(message);
    }
}
