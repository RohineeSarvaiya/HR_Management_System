package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Services.employeeServices;

@Controller
public class LogoutController {
	
	@Autowired
	private employeeServices empServices;
	
	@RequestMapping("/logout")
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {		
		ModelAndView mv = new ModelAndView();
	
		empServices.setUserName(null);
		mv.addObject("userName", null);
		mv.setViewName("login");
		
		return mv;
	}
}
