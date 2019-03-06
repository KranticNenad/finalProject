package it.eng.model;

import java.util.Date;

import it.eng.dao.EmployeeDao;

public class Test {

	public static void main(String[] args) {
		Employee employee = new Employee();
		
		employee.setEmployeeId(1245L);
		employee.setName("Aleksandar");
		employee.setSurname("Mitrovic");
		employee.setDob(new Date(1993, 5, 23));
		employee.setSalary(15000.00);
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		
		employeeDao.createEmployee(employee);
	}

}
