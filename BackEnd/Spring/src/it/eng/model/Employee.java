package it.eng.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Object to bind to database table using JPA (Hibernate) via annotations
@Entity
@Table(name = "employees")
public class Employee {

	// Declaring object field employeeId as primary key for table
	@Id
	@Column(name = "employeeid")
	private Long employeeId;
	private String name;
	private String surname;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private Double salary;
	private String about;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "employee")
	@JsonIgnore
	private List<Warrant> warrants;

	// Constructor with no arguments
	public Employee() {
	}

	// Constructor with arguments
	public Employee(Long employeeId, String name, String surname, Date dob, Double salary, String about,
			List<Warrant> warrants) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.salary = salary;
		this.about = about;
		this.warrants = warrants;
	}

	// toString method implementation
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", surname=" + surname + ", dob=" + dob
				+ ", salary=" + salary + ", about=" + about + ", warrants=" + warrants + "]";
	}

	// Getters and setters
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

	public List<Warrant> getWarrants() {
		return warrants;
	}

	public void setWarrants(List<Warrant> warrants) {
		this.warrants = warrants;
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

	// equals method implementation
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
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
		if (warrants == null) {
			if (other.warrants != null) {
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
		if (!warrants.equals(other.warrants)) {
			return false;
		}
		return true;
	}
}
