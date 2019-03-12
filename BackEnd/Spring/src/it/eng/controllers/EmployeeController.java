package it.eng.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import it.eng.model.Employee;
import it.eng.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	
	@GetMapping("/employees")
	public @ResponseBody List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}
	
	
	@GetMapping("/employees/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable Long id) {
		return employeeService.getEmployee(id);
	}

	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}

	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		Employee foundEmployee = employeeService.getEmployee(id);
		if (foundEmployee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
		Employee foundEmployee = employeeService.getEmployee(id);
		if (foundEmployee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		employeeService.deleteEmployee(foundEmployee);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
}
