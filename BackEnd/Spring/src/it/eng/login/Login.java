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
import it.eng.model.User;
import it.eng.services.UserService;

@CrossOrigin(origins = "http://localhost:4200",allowCredentials="true",allowedHeaders="true")
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
			System.out.println("USER DOES NOT EXIST");
			loginm.setStatus("dne");
			return loginm;
		}
		else if(auth.equals("false")) {
			loginm.setStatus("false");
			loginm.setAuth("false");
			System.out.println("USER FALSE");

			return loginm;
		}
		
		else {		
			HttpSession session = request.getSession();
//			ObjectMapper mapper = new ObjectMapper();
			User user = userService.getUser(username);
			System.out.println("USER TRUE");

//			try {
//				user =  mapper.readValue(auth, User.class);
//			} catch (JsonParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			session.setAttribute("session", "true");
			session.setAttribute("user",loginm);
			loginm.setStatus("true");
			loginm.setAuth(user.getAuthority());
			System.out.println(user.getAuthority());
			loginm.setUserName(user.getUsername());
			return loginm;
		}
	}
	
	@RequestMapping(value = "/check")
	public @ResponseBody LoginM checkSession(HttpServletRequest request) {
		LoginM loginm= new LoginM();
		HttpSession session = request.getSession(false);		
		if(session==null ||  session.getAttribute("session")==null) {
			System.out.println("SESIJA NE POSTOJI");
			loginm.setStatus("false");
			loginm.setAuth("testiranje");
			return loginm;
		}
		else {
			System.out.println("SETOVANA");
			LoginM loginm2 =(LoginM) session.getAttribute("user");						
			return loginm2;
		}
	}
	@RequestMapping(value = "/logout")
	public @ResponseBody LoginM destroySession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);		
		session.invalidate();
		System.out.println(session);
		LoginM loginm= new LoginM();
		loginm.setStatus("Session Destroyed");
		return loginm;
	}
}