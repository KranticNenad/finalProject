package it.eng.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import it.eng.hibernateUtil.HibernateUtil;
import it.eng.model.Warrant;

@Component("warrantDao")
public class WarrantDao {
	
	public void createWarrant(Warrant warrant) {
		Session session =HibernateUtil.SessionFactory().openSession();  
		Transaction t = session.beginTransaction(); 
		session.save(warrant);
		t.commit();
		System.out.println("WARRANT created");
		session.close();	
	}
	
	public void deleteWarrant(Warrant warrant) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction transaction= session.beginTransaction();
		session.remove(warrant);
		transaction.commit();
		System.out.println("WARRANT IS DELETED");
		session.close();
	}
	
	public void updateWarrant(Warrant warrant) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction transaction= session.beginTransaction();
		session.update(warrant);
		transaction.commit();
		System.out.println("WARRANT IS UPDATED");
		session.close();
	}
	public Warrant getWarrant(long id) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Warrant warrant= session.get(Warrant.class, id);
		System.out.println("GET WARRANT");
		session.close();
		return warrant;
	}
	public List<Warrant> getAllWarrants() {
		Session session = HibernateUtil.SessionFactory().openSession();
		Query<Warrant> q = session.createQuery("FROM Warrant", it.eng.model.Warrant.class);
		List<Warrant> warrants = q.list();
		session.close();
		return warrants;
	}
	
}
