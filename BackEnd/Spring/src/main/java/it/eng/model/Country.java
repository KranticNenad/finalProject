package it.eng.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Object to bind to database table using JPA (Hibernate) via annotations  
@Entity
@Table(name = "countries")
public class Country {
	
	/* countryCode VARCHAR(3) NOT NULL
	 * name VARCHAR (30) NOT NULL
	 */
	
	
	
	@Id
	@Column(name = "countrycode")
	/* 
	 * sets countryCode as the primary key for country and maps
	 *  one side of the manyToOne relationship
	 */
	@OneToMany(mappedBy = "locationCode")
	private String countryCode;
	@Column(name = "name")
	private String name;
	
	// Getters and setters
	public String getCountrycode() {
		return countryCode;
	}
	public void setCountrycode(String countrycode) {
		this.countryCode = countrycode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// Constructor with arguments
	public Country(String countrycode, String name) {
		super();
		this.countryCode = countrycode;
		this.name = name;
	}
	// Constructor with no arguments
	public Country() {
		
	}
	
	// toString method implementation
	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", name=" + name + "]";
	}
	
	// equals method implementation
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		Country other = (Country) obj;
		if(countryCode == null) {
			if(other.countryCode != null) {
				return false;
			}
		}
		if(name == null) {
			if(other.name != null) {
				return false;
			}
		}
		return true;
	}
	

}
