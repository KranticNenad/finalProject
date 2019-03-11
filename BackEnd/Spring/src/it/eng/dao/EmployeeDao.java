package it.eng.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import it.eng.hibernateUtil.HibernateUtil;
import it.eng.model.Employee;

@Component("employeeDao")
public class EmployeeDao {

	public void createEmployee(Employee employee) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(employee);
		t.commit();
		System.out.println("EMPLOYEE CREATED");
		session.close();
	}

	public void deleteEmployee(Employee employee) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.remove(employee);
		transaction.commit();
		System.out.println("EMPLOYEE IS DELETED");
		session.close();
	}

	public void updateEmployee(Employee employee) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(employee);
		transaction.commit();
		System.out.println("EMPLOYEE IS UPDATED");
		session.close();
	}

	public Employee getEmployee(long id) {
		Session session = HibernateUtil.SessionFactory().openSession();
		Employee employee = session.get(Employee.class, id);
		System.out.println("GET EMPLOYEE");
		session.close();
		return employee;
	}

	public List<Employee> getAllEmployees() {
		Session session = HibernateUtil.SessionFactory().openSession();
		Query<Employee> q = session.createQuery("FROM Employee", it.eng.model.Employee.class);
		List<Employee> employees = q.list();
		session.close();
		return employees;
	}

}
