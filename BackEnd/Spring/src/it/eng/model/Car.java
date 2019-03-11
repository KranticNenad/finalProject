package it.eng.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Object to bind to database table using JPA (Hibernate) via annotations
@Entity
@Table(name = "cars")
public class Car {

	/*
	 * regno VARCHAR2(10) NOT NULL travelledkm NUMBER(8,2) NOT NULL avgfueluse
	 * NUMBER(3,1) NOT NULL isinuse NUMBER DEFAULT 0 NOT NULL model VARCHAR2(20) NOT
	 * NULL
	 */

	// Declaring object field regNo as primary key for table
	@Id
	@Column(name = "regno")
	private String regNo;
	@Column(name = "travelledkm")
	private Double travelledKm;
	@Column(name = "avgfueluse")
	private Double avgFuelUse;
	@Column(name = "isinuse")
	private Boolean isInUse;
	private String model;
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "car")
	private List<Warrant> warrants;

	// Constructor without arguments
	public Car() {
	}

	// Constructor with arguments
	public Car(String regNo, Double travelledKm, Double avgFuelUse, Boolean isInUse, String model,
			List<Warrant> warrants) {
		this.regNo = regNo;
		this.travelledKm = travelledKm;
		this.avgFuelUse = avgFuelUse;
		this.isInUse = isInUse;
		this.model = model;
		this.warrants = warrants;
	}

	// Getters and setters
	public String getRegNo() {
		return regNo;
	}

	public List<Warrant> getWarrants() {
		return warrants;
	}

	public void setWarrants(List<Warrant> warrants) {
		this.warrants = warrants;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public Double getTravelledKm() {
		return travelledKm;
	}

	public void setTravelledKm(Double travelledKm) {
		this.travelledKm = travelledKm;
	}

	public Double getAvgFuelUse() {
		return avgFuelUse;
	}

	public void setAvgFuelUse(Double avgFuelUse) {
		this.avgFuelUse = avgFuelUse;
	}

	public Boolean getIsInUse() {
		return isInUse;
	}

	public void setIsInUse(Boolean isInUse) {
		this.isInUse = isInUse;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	// toString method implementation
	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", travelledKm=" + travelledKm + ", avgFuelUse=" + avgFuelUse + ", isInUse="
				+ isInUse + ", model=" + model + ", warrants=" + warrants + "]";
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
		Car other = (Car) obj;
		if (regNo == null) {
			if (other.regNo != null) {
				return false;
			}
		}
		if (travelledKm == null) {
			if (other.travelledKm != null) {
				return false;
			}
		}
		if (avgFuelUse == null) {
			if (other.avgFuelUse != null) {
				return false;
			}
		}
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		}
		if (isInUse == null) {
			if (other.isInUse != null) {
				return false;
			}
		}
		if (warrants == null) {
			if (other.warrants != null) {
				return false;
			}
		}
		if (!regNo.equals(other.regNo)) {
			return false;
		}
		if (!travelledKm.equals(other.travelledKm)) {
			return false;
		}
		if (!avgFuelUse.equals(other.avgFuelUse)) {
			return false;
		}
		if (!isInUse.equals(other.isInUse)) {
			return false;
		}
		if (!model.equals(other.model)) {
			return false;
		}
		if (!warrants.equals(other.warrants)) {
			return false;
		}
		return true;
	}

	

}
