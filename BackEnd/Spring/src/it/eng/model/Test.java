package it.eng.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.eng.dao.EmployeeDao;
import it.eng.hibernateUtil.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
//		System.out.println("test");
//		Employee employee = new Employee();
//		employee.setName("Rich");
//		employee.setSurname("Evans");
//		try {
//			employee.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("15/02/1993"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		employee.setEmployeeId(1234567890L);
//		employee.setSalary(1500.23);
//		
//		Employee employee2 = new Employee();
//		employee2.setName("Michael");
//		employee2.setSurname("Baumann");
//		employee2.setDob(new Date (1989, 5, 23));
//		employee2.setEmployeeId(1234567891L);
//		employee2.setSalary(14500.50);
//		
		EmployeeDao employeeDao = new EmployeeDao();
		
//		employeeDao.createEmployee(employee);
//		employeeDao.createEmployee(employee2);
		
//		System.out.println("GET ALL TEST");
//		for(Employee e : employeeDao.getAllEmployees()) {
//			System.out.println(e.toString());
//		}
		System.out.println("GET 1 TEST");
		System.out.println(employeeDao.getEmployee(34523L).toString());
		for (Warrant w : employeeDao.getEmployee(34523L).getWarrants()) {
			System.out.println(w.toString());
		}
//		System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(employeeDao.getEmployee(1234567890L).getDob()));
//		
//		employeeDao.deleteEmployee(employee2);
//		System.out.println("DELETED TEST");
//		for(Employee e : employeeDao.getAllEmployees()) {
//			System.out.println(e.toString());
//		}
//		
//		employee.setSalary(0.0);
//		employeeDao.updateEmployee(employee);
//		System.out.println("UPDATE TEST");
//		System.out.println(employeeDao.getEmployee(1234567890L).toString());
		
		
		
		HibernateUtil.destroySessionFactory();
				
	}

}
