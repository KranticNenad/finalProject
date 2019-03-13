package it.eng.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import it.eng.model.User;
import it.eng.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users/{username}")
	public @ResponseBody User getUser(@PathVariable String username) {
		return userService.getUser(username);
	}
	
	@GetMapping("/users")
	public @ResponseBody List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		userService.createUser(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User foundUser = userService.getUser(user.getUsername());
		if(foundUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.updateUser(foundUser);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable String username){
		User foundUser = userService.getUser(username);
		if(foundUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(foundUser);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}
