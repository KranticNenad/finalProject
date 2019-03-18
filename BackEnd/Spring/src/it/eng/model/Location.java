package it.eng.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Object to bind to database table using JPA (Hibernate) via annotations
@Entity
@Table(name = "locations")
public class Location {

	@Id
	@Column(name = "locationcode")
	private String locationCode;
	private String name;
	private Double dailyPayment;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "locations")
	@JsonIgnore
	private List<Warrant> warrants;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne
	@JoinColumn(name = "countries_countrycode")
	private Country country;

	public Location() {
	}

	public Location(String locationCode, String name, Double dailyPayment, List<Warrant> warrants, Country country) {
		this.name = name;
		this.locationCode = locationCode;
		this.dailyPayment = dailyPayment;
		this.warrants = warrants;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public List<Warrant> getWarrants() {
		return warrants;
	}

	public void setWarrants(List<Warrant> warrants) {
		this.warrants = warrants;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Double getDailyPayment() {
		return dailyPayment;
	}

	public void setDailyPayment(Double dailyPayment) {
		this.dailyPayment = dailyPayment;
	}

	@Override
	public String toString() {
		return "Location [locationCode=" + locationCode + 
				"name=" + name + ", dailyPayment=" + dailyPayment 
				+ ", country=" + country.getCountryCode() + "]";
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
		Location other = (Location) obj;
		if (locationCode == null) {
			if (other.locationCode != null) {
				return false;
			}
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		}
		if (dailyPayment == null) {
			if (other.dailyPayment != null) {
				return false;
			}
		}
		if (warrants == null) {
			if (other.warrants != null) {
				return false;
			}
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		}
		if (!locationCode.equals(other.locationCode)) {
			return false;
		}
		if (!name.equals(other.name)) {
			return false;
		}
		if (!dailyPayment.equals(other.dailyPayment)) {
			return false;
		}
		if (!warrants.equals(other.warrants)) {
			return false;
		}
		if (!country.equals(other.country)) {
			return false;
		}
		return true;
	}

}
