package Services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import Model.Employee;

@Service
public class employeeServices {
	
	@Autowired
	private RestTemplate template;
	
	private String userName;
	
	String url = "http://localhost:9099/api/employees";
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	// Get all employees data from restapi
	public List<Employee> getAllEmployees(){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);		
		ResponseEntity<Employee[]> responseEntity = template.exchange(url,HttpMethod.GET,entity,Employee[].class);
		
		Employee[] emp = responseEntity.getBody();
		List<Employee> employees = Arrays.asList(emp);
		return employees;
	}
	
	
	// Upload new employee details on restapi
	public List<Employee> uploadEmployee(Employee employee) {
        template.postForEntity(url, employee, Employee.class);
        List<Employee> employees = getAllEmployees();
		return employees;
	}

	
	// Get employee by employee code from restapi
	public Employee getEmployeeByemployeeCode(Long employeeCode) {
		ResponseEntity<Employee> responseEntity = template.getForEntity(url+"/"+employeeCode, Employee.class);
		Employee employee = responseEntity.getBody();
		return employee;
    }
	
	
	// Update employee details on restapi
	public List<Employee> updateEmployee(Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,headers);
		template.exchange(url,HttpMethod.POST, entity, Employee.class);
		List<Employee> employees = getAllEmployees();
		return employees;	

	}
	
	
	// Delete employee details from restapi
	public List<Employee> deleteEmployee (Long employeeCode) {
		template.delete(url+"/"+employeeCode , Employee.class);
		List<Employee> employees = getAllEmployees();
		return employees;
	}
	
	
	// Converting employee object list to Json format string
	public String convertToJsonString(List<Employee> employees) {
		Gson gson = new Gson();
		String employeeJsonData = gson.toJson(employees);
		return employeeJsonData;
	}
	
	
	// Returning file which contains employee details in json string format
	public ResponseEntity<byte[]> returnFile(List<Employee> employees , byte[] employeeJsonData) {	
		ResponseEntity<byte[]> responseEntity =  ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=EmployeeDetails.json")
				.contentType(MediaType.APPLICATION_JSON).contentLength(employeeJsonData.length)
				.body(employeeJsonData);
		
		return responseEntity;
	}
	
}
