package it.eng.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import it.eng.hibernateUtil.HibernateUtil;
import it.eng.model.User;

@Component("userDao")
public class UserDao {
	
	public void createUser(User user) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(user);
		t.commit();
		System.out.println("USER IS CREATED");
		session.close();
	}
	
	public void deleteUser(User user) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.remove(user);
		t.commit();
		System.out.println("USER IS DELETED");
		session.close();
	}
	
	public void updateUser(User user) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(user);
		t.commit();
		System.out.println("USER IS UPDATED");
		session.close();
	}
	
	public User getUser(String username) {
		Session session = HibernateUtil.SessionFactory().openSession();
		User user = session.get(User.class, username);
		System.out.println("GET USER");
		session.close();
		return user;
	}
	
	public List<User> getAllUsers(){
		Session session = HibernateUtil.SessionFactory().openSession();
		Query<User> q = session.createQuery("FROM User", it.eng.model.User.class);
		List<User> users = q.list();
		session.close();
		return users;
	}
}
