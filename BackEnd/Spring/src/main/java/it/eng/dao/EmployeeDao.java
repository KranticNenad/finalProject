package it.eng.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import it.eng.model.Employee;


@Component("employeeDao")
public class EmployeeDao {

	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build(); 
	
	SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	Session session = factory.openSession();  
	Transaction t = session.beginTransaction();  
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public List<Employee> getEmployees() {

		return jdbc.query("SELECT * FROM employees", new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();

				employee.setEmployeeId(rs.getLong("employeeid"));
				employee.setName(rs.getString("name"));
				employee.setSurname(rs.getString("surname"));
				employee.setDob(rs.getDate("dob"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setAbout(rs.getString("about"));

				return employee;
			}
		});
	}

	public Employee getEmployeeById(Long employeeId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("employeeid", employeeId);

		return jdbc.queryForObject("SELECT * FROM employees WHERE employeeid = :employeeid", params,
				new RowMapper<Employee>() {

					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee employee = new Employee();

						employee.setEmployeeId(rs.getLong("employeeid"));
						employee.setName(rs.getString("name"));
						employee.setSurname(rs.getString("surname"));
						employee.setDob(rs.getDate("dob"));
						employee.setSalary(rs.getDouble("salary"));
						employee.setAbout(rs.getString("about"));

						return employee;
					}
				});
	}
	
	public boolean deleteOfferById(Long employeeId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("employeeid", employeeId);

		return jdbc.update("DELETE FROM employees WHERE employeeid = :employeeid", params) == 1;
	}
	
	public void createEmployee(Employee employee) {
		session.save(employee);
		t.commit();
		System.out.println("Employee created");
		factory.close();
		session.close();		
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("employeeid", employee.getEmployeeId());
//		params.addValue("name", employee.getName());
//		params.addValue("surname", employee.getSurname());
//		params.addValue("text", employee.getAbout());
//
//
//		return jdbc.update("INSERT INTO offers (id, name, email, text) VALUES" + "(:id, :name, :email, :text)",
//				params) == 1;
	}
}
