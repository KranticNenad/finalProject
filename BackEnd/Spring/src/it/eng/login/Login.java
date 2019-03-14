package it.eng.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.eng.model.LoginM;
import it.eng.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class Login {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login")
	public @ResponseBody LoginM returnSession(@RequestParam String username,@RequestParam String password,HttpServletRequest request) {
		String auth = userService.loginUser(username, password);
		LoginM loginm= new LoginM();
		System.out.println(auth);
		if(auth.equals("User does not exist!")) {
			loginm.setStatus("dne");
			return loginm;
		}
		else if(auth.equals("true")) {
			HttpSession session = request.getSession();
			session.setAttribute("session", "true");
			loginm.setStatus("true");
			return loginm;
		}
		
		else {		
			loginm.setStatus("false");	
			return loginm;
		}
	}
	
	@RequestMapping(value = "/check")
	public @ResponseBody LoginM checkSession(HttpServletRequest request) {
		LoginM loginm= new LoginM();
		HttpSession session = request.getSession(false);		
		if(session==null) {
			loginm.setStatus("false");
			return loginm;
		}
		else {
			System.out.println("SETOVANA");
			loginm.setStatus("true");
			return loginm;
		}
	}
	
}
