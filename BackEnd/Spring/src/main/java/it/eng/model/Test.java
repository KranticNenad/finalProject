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
		
		Employee employee2 = new Employee();
		
		employee2.setEmployeeId(1246L);
		employee2.setName("Dimitrije");
		employee2.setSurname("Lukovic");
		employee2.setDob(new Date(1987, 2, 15));
		employee2.setSalary(15456.43);
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		for(Employee e : employeeDao.getEmployees()) {
			System.out.println(e.toString());
		}
		employeeDao.destroy();
	}
}
