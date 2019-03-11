package it.eng.test.tests;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.eng.dao.EmployeeDao;
import it.eng.model.Employee;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:it/eng/config/dao-context.xml",
		"classpath:it/eng/config/services-context.xml",
		"classpath:it/eng/test/config/test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoTests {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init() {
		System.out.println("Cleaning DB before testing");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("DELETE FROM employees");
	}
	
	@Test
	public void testCreateNewEmployee() {
		Employee employee = new Employee();
		employee.setName("Rich");
		employee.setSurname("Evans");
		try {
			employee.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("15/02/1993"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		employee.setEmployeeId(1234567890L);
		employee.setSalary(1500.23);
		
		employeeDao.createEmployee(employee);
		List<Employee> employees = employeeDao.getAllEmployees();
		assertEquals("There should be 1 record in the database.", 1, employees.size());
		assertEquals(employee.getEmployeeId(), employees.get(0).getEmployeeId());
		assertEquals(employee.getName(), employees.get(0).getName());
		assertEquals(employee.getSurname(), employees.get(0).getSurname());
		assertEquals(employee.getSalary(), employees.get(0).getSalary());
		assertEquals(employee.getDob(), employees.get(0).getDob());
		assertEquals(employee.getAbout(), employees.get(0).getAbout());
	}
}
