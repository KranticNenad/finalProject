package it.eng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eng.dao.UserDao;
import it.eng.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUser(String username) {
		return userDao.getUser(username);
	}

	public void createUser(User user) {
		userDao.createUser(user);
	}

	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public String loginUser(String username, String password) {
		User user = userDao.getUser(username);
		if(user==null) {
			return "User does not exist!";
		}
		
		else {
		if (user.getPassword().equals(password)) {
			return "true";
			} 
		else {
				return "false";
			}
		}	
	}
}
