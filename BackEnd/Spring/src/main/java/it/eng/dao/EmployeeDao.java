package it.eng.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import it.eng.model.Employee;

/* Data access object for Employee class, 
configured for Spring dependency injection via annotations*/
@Component("employeeDao")
public class EmployeeDao {

	// Configuring needed services and metadata for Hibernate
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

	// creating new session factory so that we can instantiate sessions
	SessionFactory factory = meta.getSessionFactoryBuilder().build();

	// get all employees from database
	public List<Employee> getEmployees() {
		// opening new session that's instanced from session factory
		Session session = factory.openSession();
		/*
		 * creating a new query object and instancing it from session. the query itself
		 * is written in Hibernate Query Language (HQL) in this particular instance
		 * pretty close to regular SQL
		 */
		Query<Employee> q = session.createQuery("FROM Employee", it.eng.model.Employee.class);
		// returns query result as a list of type List<Employee> and saves it to
		// employees variable so that data persists after closing session
		List<Employee> employees = q.list();
		// destroying factory and session instances
		session.close();
		factory.close();
		return employees;
	}

	public Employee getEmployeeById(Long employeeId) {
		// opening new session that's instanced from session factory
		Session session = factory.openSession();
		/*
		 * creating a new query object and instancing it from session. the query itself
		 * is written in HQL
		 */
		
//		Query<Employee> q = session.
//				createQuery("FROM Employee WHERE Employee.employeeId = :employeeId",
//				it.eng.model.Employee.class).setParameter(0, employeeId);
		// returns query result as an object of type Employee and saves it to
		// employee variable so that data persists after closing session
		Employee employee = session.get(Employee.class, employeeId);
		// destroying factory and session instances
		session.close();
		factory.close();
		return employee;
	}

//	public boolean deleteOfferById(Long employeeId) {
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("employeeid", employeeId);
//
//		return jdbc.update("DELETE FROM employees WHERE employeeid = :employeeid", params) == 1;
//	}

	// method for creating a new employee
	public void createEmployee(Employee employee) {
		// opening new session that's instanced from session factory
		Session session = factory.openSession();
		// opening transaction so that rollback is possible in case of failure
		Transaction t = session.beginTransaction();
		// writing object to database via Hibernate
		session.save(employee);
		// commits changes to database
		t.commit();
		System.out.println("Employee created");
		// destroying factory and session instances
		session.close();
		factory.close();
	}
}
