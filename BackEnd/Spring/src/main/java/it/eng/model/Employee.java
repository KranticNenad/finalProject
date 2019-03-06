package it.eng.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@Column(name="employeeid")
	private Long employeeId;
	private String name;
	private String surname;
	private Date dob;
	private Double salary;
	private String about;

	public Employee() {
	}

	public Employee(Long employeeId, String name, String surname, Date dob, Double salary, String about) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.salary = salary;
		this.about = about;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", surname=" + surname + ", dob=" + dob
				+ ", salary=" + salary + ", about=" + about + "]";
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null) {
				return false;
			}
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		}
		if (surname == null) {
			if (other.surname != null) {
				return false;
			}
		}
		if (dob == null) {
			if (other.dob != null) {
				return false;
			}
		}
		if (salary == null) {
			if (other.salary != null) {
				return false;
			}
		}
		if (about == null) {
			if (other.about != null) {
				return false;
			}
		}
		if (!employeeId.equals(other.employeeId)) {
			return false;
		}
		if (!name.equals(other.name)) {
			return false;
		}
		if (!surname.equals(other.surname)) {
			return false;
		}
		if (!dob.equals(other.dob)) {
			return false;
		}
		if (!salary.equals(other.salary)) {
			return false;
		}
		if (!about.equals(other.about)) {
			return false;
		}
		return true;
	}
}
