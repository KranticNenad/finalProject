package it.eng.model;

import java.util.List;

import it.eng.dao.CarDao;
import it.eng.dao.UserDao;
import it.eng.hibernateUtil.HibernateUtil;


public class Test {

	public static void main(String[] args) {
		
			
		UserDao ud= new UserDao();
		CarDao cd = new CarDao();
		List<Car> cars= cd.getAllUserCars("fkurtaj");
		for(Car car: cars) {
			System.out.println(car);
		}
		HibernateUtil.destroySessionFactory();
				
	}

}
