package it.eng.dao;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import it.eng.hibernateUtil.HibernateUtil;
import org.hibernate.query.Query;
import it.eng.model.Country;

@Component("countryDao")
public class CountryDao {

	// Create Country in database
	public void createCountry(Country country) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(country);
		t.commit();
		System.out.println("COUNTRY CREATED");
		session.close();
	}

	public void deleteCountry(Country country) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.remove(country);
		t.commit();
		System.out.println("COUNTRY DELETED");
		session.close();
	}
	
	public void updateCountry(Country country) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(country);
		t.commit();
		System.out.println("UPDATED COUNTRY");
		session.close();
	}
	
	public Country getCountry(String countryCode) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Country country = session.get(Country.class, countryCode);
		System.out.println("GET COUNTRY");
		session.close();
		return country;		
	}
	
	public List<Country> getAllCountries(){
		Session session = HibernateUtil.SessionFactory().openSession();
		Query<Country> q = session.createQuery("FROM Country", it.eng.model.Country.class);
		List<Country> countries = q.list();
		session.close();
		return countries;
		
	}
}
