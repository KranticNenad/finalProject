package it.eng.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import it.eng.hibernateUtil.HibernateUtil;
import it.eng.model.*;

@Component("carDao")
public class CarDao {
		
	public void createCar(Car car) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction transaction= session.beginTransaction();
		session.save(car);
		transaction.commit();
		System.out.println("CAR CREATED");
	}
	
	public void deleteCar(Car car) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction transaction= session.beginTransaction();
		session.remove(car);
		transaction.commit();
		System.out.println("CAR IS DELETED");
		session.close();
	}
	
	public void updateCar(Car car) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction transaction= session.beginTransaction();
		session.update(car);
		transaction.commit();
		System.out.println("CAR IS UPDATED");
		session.close();
	}
	
	public Car getCar(String id) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction transaction= session.beginTransaction();
		Car car= session.get(Car.class, id);
		transaction.commit();
		System.out.println("GET A CAR");
		session.close();
		return car;
	}
	
	public List<Car> getAllCars() {
		Session session = HibernateUtil.SessionFactory().openSession();
		Query<Car> q = session.createQuery("FROM Car", it.eng.model.Car.class);
		List<Car> cars = q.list();
		session.close();
		return cars;
	}
	
	public List<Car> searchCars(String model) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Query<Car> q = session.createQuery("FROM Car WHERE model=model ", it.eng.model.Car.class);
		List<Car> cars = q.list();
		session.close();
		return cars;
	}
	
	public List<Car> getAllUserCars(String user) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Query<Warrant> q = session.createQuery("FROM Warrant", it.eng.model.Warrant.class);
		List<Warrant> warrants = q.list();
		List<Car> cars = new ArrayList<Car>();
		for(Warrant warrant: warrants) {
			if(warrant.getUser().getUsername().equals(user)) {
				cars.add(warrant.getCar());
			}
		}
		
		session.close();
		return cars;
	}
	
}
