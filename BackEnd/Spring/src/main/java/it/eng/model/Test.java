package it.eng.model;

import java.util.Date;

import it.eng.dao.EmployeeDao;

public class Test {

	public static void main(String[] args) {
		Employee employee = new Employee();
		
		employee.setEmployeeId(1244564565L);
		employee.setName("Aleksandar");
		employee.setSurname("Mitrovic");
		employee.setDob(new Date(1993, 5, 23));
		employee.setSalary(15000.00);
		
		EmployeeDao employeeDao = new EmployeeDao();
		
//		for (Employee e : employeeDao.getEmployees()) {
//			System.out.println(e.toString());
//		}
		
		System.out.println(employeeDao.getEmployeeById(1244564565L).toString());
		
//		employeeDao.createEmployee(employee);
	}

}
