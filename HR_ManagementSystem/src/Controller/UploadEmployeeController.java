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
public class UploadEmployeeController {
	
	@Autowired
	private employeeServices empServices;
	
	// for redirecting to uploadEmployee Page
	@RequestMapping("/upload")
	public ModelAndView upload( HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();		
		
		String userName = empServices.getUserName();
		
		mv.addObject("userName", userName);
		mv.setViewName("uploadEmployee");
		
		return mv;
	}
	
	// for uploading employee details on restapi and table on submission
	@RequestMapping("/uploadEmployee")
	public ModelAndView uploadEmployee( HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		String empName = request.getParameter("empname");
		String empLocation = request.getParameter("emplocation");
		String empEmail = request.getParameter("empemail");
		String empDob = request.getParameter("empdob");
		
		Employee employee = new Employee(empName ,empLocation , empEmail,empDob );
	
		List<Employee> employees = empServices.uploadEmployee(employee);
		String userName = empServices.getUserName();
		
		mv.addObject("employees", employees);
		mv.addObject("userName", userName);
		mv.setViewName("employeeDetails");
		
		return mv;
	}

}
