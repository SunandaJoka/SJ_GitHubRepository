package com.immaginovate.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Employee_Details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int id;
	
	@Column(name="first_name")
	@NotBlank(message = "First Name is mandatory")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message = "Last Name is mandatory")
	private String lastName;

	@Column(name="email")
	@Email(message= "Email should be valid")
	private String email;
	
	@Column(name="phone_number")
	@NotBlank(message = "Phone Number is mandatory")
	@Pattern(regexp="(^$|[0-9]{10})")
	private List<String> phoneNumber;
	
	@Column(name="date_of_joining")
	@Past(message="Date should be in the past")
	@NotBlank(message = "Date of joining is mandatory")
	private Date doj;
	
	@Column(name="salaryPerMonth")
	@Positive(message="Salary is a positive value")
	@NotBlank(message = "Salary is mandatory")
	private double salary;
	
	public Employee() {		
	}
	
	public Employee(int id, @NotBlank(message = "First Name is mandatory") String firstName,
			@NotBlank(message = "Last Name is mandatory") String lastName,
			@Email(message = "Email should be valid") String email,
			@NotBlank(message = "Phone Number is mandatory") @Pattern(regexp = "(^$|[0-9]{10})") List<String> phoneNumber,
			@Past(message = "Date should be in the past") @NotBlank(message = "Date of joining is mandatory") Date doj,
			@Positive(message = "Salary is a positive value") @NotBlank(message = "Salary is mandatory") double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.doj = doj;
		this.salary = salary;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
