package it.eng.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.eng.model.Employee;
import it.eng.services.EmployeeService;

@Controller
@SessionAttributes("name")
public class Login {
	
	
	@RequestMapping(value = "/login")
	public @ResponseBody String returnSession(@RequestParam String name,HttpServletRequest request) {
		HttpSession sesija = request.getSession();
		sesija.setAttribute("name", name);
		return "USPESNO";
}
	@GetMapping(value="/check") 
		public @ResponseBody String checkSession(HttpServletRequest request) {
		HttpSession sesija = request.getSession();
				return (String) sesija.getAttribute("name");
		}
	
	
}
