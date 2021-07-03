package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Model.Employee;
import Services.employeeServices;

@Controller
public class UpdateEmployeeController {
	
	@Autowired
	private employeeServices empServices;
	
	// for redirecting to updateEmployee page 
	@RequestMapping("/update")
	public ModelAndView update( HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();		
		Long employeeCode = Long.parseLong(request.getParameter("employeecode"));
		
		Employee employee = empServices.getEmployeeByemployeeCode(employeeCode);
		String userName = empServices.getUserName();
		
		mv.addObject("userName", userName);
		mv.addObject("Employee", employee);
		mv.setViewName("updateEmployee");
		
		return mv;
	}
	
	
	// for updating employee details in table and restapi on submission
	@RequestMapping("/updateEmployee")
	public ModelAndView updateEmployee( HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();		
		Long employeeCode = Long.parseLong(request.getParameter("empcode"));
		
		String empName = request.getParameter("empname");
		String empLocation = request.getParameter("emplocation");
		String empEmail = request.getParameter("empemail");
		String empDob = request.getParameter("empdob");
		
		Employee employee = new Employee(empName ,empLocation , empEmail,empDob );
		employee.setEmployeeCode(employeeCode);
		
		List<Employee> employees = empServices.updateEmployee(employee );
		String userName = empServices.getUserName();
		
		mv.addObject("employees", employees);
		mv.addObject("userName", userName);
		mv.setViewName("employeeDetails");
		
		return mv;
	}

}
