package EmployeeManagement.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Employee_Code")
	private long employeeCode;
	
	@Column(name="Employee_Name")
	private String employeeName;
	
	@Column(name="Employee_Location")
	private String employeeLocation;
	
	@Column(name="Employee_Email")
	private String employeeEmail;
	
	@Column(name="Employee_Dob")
	private String employeeDob;
	
	
	public Employee() {
		
	}
	
	public Employee(String employeeName, String employeeLocation, String employeeEmail, String employeeDob) {
		super();
		this.employeeName = employeeName;
		this.employeeLocation = employeeLocation;
		this.employeeEmail = employeeEmail;
		this.employeeDob = employeeDob;
	}



	public long getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(long employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeLocation() {
		return employeeLocation;
	}
	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeDob() {
		return employeeDob;
	}
	public void setEmployeeDob(String employeeDob) {
		this.employeeDob = employeeDob;
	}
	
}
