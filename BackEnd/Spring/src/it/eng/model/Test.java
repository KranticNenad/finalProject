package it.eng.model;

import it.eng.dao.UserDao;
import it.eng.hibernateUtil.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
			
		UserDao ud= new UserDao();
		User user= ud.getUser("fkurtaj");		
		System.out.println(user);
		HibernateUtil.destroySessionFactory();
				
	}

}
