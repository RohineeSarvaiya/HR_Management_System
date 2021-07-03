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
public class DeleteEmployeeController {
	
	@Autowired
	private employeeServices empServices;
	
	@RequestMapping("/delete")
	public ModelAndView delete( HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		Long employeeCode = Long.parseLong(request.getParameter("employeecode"));		
		String userName = empServices.getUserName();
		
		List<Employee> employees = empServices.deleteEmployee(employeeCode);
		
		mv.addObject("employees", employees);
		mv.addObject("userName", userName);
		mv.setViewName("employeeDetails");
		
		return mv;
	}

}
