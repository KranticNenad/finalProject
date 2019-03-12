package it.eng.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

//Object to bind to database table using JPA (Hibernate) via annotations
@Entity
@Table(name = "warrants")
public class Warrant {

	/*
	 * issuedat DATE DEFAULT SYSDATE NOT NULL, distance NUMBER(6,2) NOT NULL,
	 * users_username VARCHAR2(16) NOT NULL, returnedat DATE, fuelused NUMBER(5,2),
	 * cars_regno VARCHAR2(10) NOT NULL, employees_employeeid NUMBER(13) NOT NULL,
	 * warrantid NUMBER NOT NULL
	 */

	// Declaring object field warrantId as primary key for table
	@Id
	@Column(name = "warrantid")
	@GeneratedValue
	private Long warrantId;
	@Temporal(TemporalType.DATE)
	@Column(name = "issuedat", insertable = false)
	private Date issuedAt;
	private Double distance;
	@Temporal(TemporalType.DATE)
	@Column(name = "returnedat")
	private Date returnedAt;
	@Column(name = "fuelused")
	private Double fuelUsed;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne
	@JoinColumn(name = "cars_regno")
	private Car car;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne
	@JoinColumn(name = "employees_employeeid")
	private Employee employee;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne
	@JoinColumn(name = "users_username")
	private User user;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany()
	@JoinTable(name = "war_loc",
	joinColumns = @JoinColumn(name = "warrants_warrantid"),
	inverseJoinColumns = @JoinColumn(name = "locations_locationcode"))
	private List<Location> locations;

	// Constructor with no arguments
	public Warrant() {
	}

	// Constructor with arguments
	public Warrant(Long warrantId, Date issuedAt, Double distance, Date returnedAt, Double fuelUsed, Car car,
			Employee employee, User user, List<Location> locations) {
		super();
		this.warrantId = warrantId;
		this.issuedAt = issuedAt;
		this.distance = distance;
		this.returnedAt = returnedAt;
		this.fuelUsed = fuelUsed;
		this.car = car;
		this.employee = employee;
		this.user = user;
		this.locations = locations;
	}

	// getters and setters
	public Long getWarrantId() {
		return warrantId;
	}

	public void setWarrantId(Long warrantId) {
		this.warrantId = warrantId;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Date getReturnedAt() {
		return returnedAt;
	}

	public void setReturnedAt(Date returnedAt) {
		this.returnedAt = returnedAt;
	}

	public Double getFuelUsed() {
		return fuelUsed;
	}

	public void setFuelUsed(Double fuelUsed) {
		this.fuelUsed = fuelUsed;
	}

	// toString method implementation
	@Override
	public String toString() {
		return "Warrant [warrantId=" + warrantId + 
				", issuedAt=" + issuedAt + 
				", distance=" + distance + 
				", returnedAt=" + returnedAt + 
				", fuelUsed=" + fuelUsed + ", car=" + car.getRegNo() + 
				", employee=" + employee.getEmployeeId() + ", user=" + user.getUsername() + 
				", locations=" + locations + "]";
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
		Warrant other = (Warrant) obj;
		if (warrantId == null) {
			if (other.warrantId != null) {
				return false;
			}
		}
		if (issuedAt == null) {
			if (other.issuedAt != null) {
				return false;
			}
		}
		if (distance == null) {
			if (other.distance != null) {
				return false;
			}
		}
		if (returnedAt == null) {
			if (other.returnedAt != null) {
				return false;
			}
		}
		if (fuelUsed == null) {
			if (other.fuelUsed != null) {
				return false;
			}
		}
		if (car == null) {
			if (other.car != null) {
				return false;
			}
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		}
		if (employee == null) {
			if (other.employee != null) {
				return false;
			}
		}
		if (locations == null) {
			if (other.locations != null) {
				return false;
			}
		}
		if (!warrantId.equals(other.warrantId)) {
			return false;
		}
		if (!issuedAt.equals(other.issuedAt)) {
			return false;
		}
		if (!distance.equals(other.distance)) {
			return false;
		}
		if (!returnedAt.equals(other.returnedAt)) {
			return false;
		}
		if (!fuelUsed.equals(other.fuelUsed)) {
			return false;
		}
		if (!car.equals(other.car)) {
			return false;
		}
		if (!user.equals(other.user)) {
			return false;
		}
		if (!employee.equals(other.employee)) {
			return false;
		}
		if (!locations.equals(other.locations)) {
			return false;
		}
		return true;
	}

}
