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
@Table(name = "countries")
public class Country {

	/*
	 * countryCode VARCHAR(3) NOT NULL name VARCHAR (30) NOT NULL
	 */

	/*
	 * sets countryCode as the primary key for country and maps one side of the
	 * manyToOne relationship
	 */
	@Id
	@Column(name = "countrycode")
	private String countryCode;
	private String name;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "country")
	@JsonIgnore
	private List<Location> locations;

	// Getters and setters

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Constructor with arguments
	public Country(String countryCode, String name, List<Location> locations) {
		this.countryCode = countryCode;
		this.name = name;
		this.locations = locations;
	}

	// Constructor with no arguments
	public Country() {

	}

	// toString method implementation
	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", name=" + name + ", locations=" + locations + "]";
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
		Country other = (Country) obj;
		if (countryCode == null) {
			if (other.countryCode != null) {
				return false;
			}
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		}
		if (locations == null) {
			if (other.locations != null) {
				return false;
			}
		}
		if (!countryCode.equals(other.countryCode)) {
			return false;
		}
		if (!name.equals(other.name)) {
			return false;
		}
		if (!locations.equals(other.locations)) {
			return false;
		}
		return true;
	}

}
