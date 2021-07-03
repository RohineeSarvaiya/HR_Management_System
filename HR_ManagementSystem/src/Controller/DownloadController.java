package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Model.Employee;
import Services.employeeServices;


@Controller
public class DownloadController {
	
	@Autowired
	private employeeServices empServices;
	
	@RequestMapping("download")
	public ResponseEntity<byte[]> downloadEmployeeDetails(){
		List<Employee> employees=empServices.getAllEmployees();		
		String dataInJsonString = empServices.convertToJsonString(employees);
		byte[] employeeJsonData = dataInJsonString.getBytes();
		
		ResponseEntity<byte[]> responseEntity = empServices.returnFile(employees, employeeJsonData);
		
		return responseEntity;
	}

}
