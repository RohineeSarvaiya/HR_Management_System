package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DAO.UserDao;
import Model.Employee;
import Services.employeeServices;


@Controller
public class LoginController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private employeeServices empServices;
	
	@RequestMapping("/login")
	public ModelAndView logIn ( HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		//getting username and password from the request
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		//validate login info
		if(!userDao.validate(userName, password))
		{
			mv.setViewName("login-fail");
			return mv;
		}
		
		empServices.setUserName(userName);
		List<Employee> employees = empServices.getAllEmployees();
		
		mv.addObject("employees", employees);
		mv.addObject("userName", userName);
		mv.setViewName("employeeDetails");
		
		return mv;
	}
	
	
	@RequestMapping("/back")
	public ModelAndView back( HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		String userName = empServices.getUserName();
		List<Employee> employees = empServices.getAllEmployees();
		
		mv.addObject("employees", employees);
		mv.addObject("userName", userName);
		mv.setViewName("employeeDetails");
		
		return mv;
	}	

}
