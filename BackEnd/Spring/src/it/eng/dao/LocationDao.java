package it.eng.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import it.eng.hibernateUtil.HibernateUtil;
import it.eng.model.Location;

@Component("locationDao")
public class LocationDao {

	public void createLocation(Location location) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(location);
		t.commit();
		System.out.println("LOCATION CREATED");
		session.close();
	}

	public void deleteLocation(Location location) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.remove(location);
		t.commit();
		System.out.println("LOCATION IS DELETED");
		session.close();
	}

	public void updateLocation(Location location) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(location);
		t.commit();
		System.out.println("LOCATION IS UPDATED");
		session.close();
	}

	public List<Location> getAllLocations() {
		Session session = HibernateUtil.SessionFactory().openSession();
		Query<Location> q = session.createQuery("FROM Location", it.eng.model.Location.class);
		List<Location> locations = q.list();
		session.close();
		return locations;
	}

	public Location getLocation(String locationCode) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Location location = session.get(Location.class, locationCode);
		System.out.println("GET LOCATION");
		session.close();
		return location;
	}
}
