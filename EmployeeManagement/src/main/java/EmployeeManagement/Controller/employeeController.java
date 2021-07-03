package EmployeeManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EmployeeManagement.Model.Employee;
import EmployeeManagement.Repository.employeeRepository;
import EmployeeManagement.Exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/employees")
public class employeeController {
	
	@Autowired
	private employeeRepository employeeRepo;
	
	
	// Get all Employees
	@GetMapping
	public List<Employee> getAllEmployees(){
		return this.employeeRepo.findAll();
	}
	
	
	// Get Employee by employeeCode
	@GetMapping("/{employeeCode}")
	public Employee getEmployeebyId(@PathVariable (value="employeeCode") long employeeCode) {
		return this.employeeRepo.findById(employeeCode)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with employeeCode :" + employeeCode));
	}
	
	
	// Create Employee
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeRepo.save(employee);
	}
	
	
	// Update Employee
	@PutMapping("/{employeeCode}")
	public Employee updateEmployee(@RequestBody Employee employee , @PathVariable (value="employeeCode") long employeeCode) {
		
		Employee existingEmployee = this.employeeRepo.findById(employeeCode)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with employeeCode :" + employeeCode));
		
		existingEmployee.setEmployeeDob(employee.getEmployeeDob());
		existingEmployee.setEmployeeEmail(employee.getEmployeeEmail());
		existingEmployee.setEmployeeLocation(employee.getEmployeeLocation());
		existingEmployee.setEmployeeName(employee.getEmployeeName());
		return this.employeeRepo.save(existingEmployee);
	}
	
	
	// Delete employee by employeecode
	@DeleteMapping("/{employeeCode}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable (value="employeeCode") long employeeCode){
		
		Employee existingEmployee = this.employeeRepo.findById(employeeCode)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with employeeCode :" + employeeCode));
		
		this.employeeRepo.delete(existingEmployee);
		return ResponseEntity.ok().build();
	}

}
