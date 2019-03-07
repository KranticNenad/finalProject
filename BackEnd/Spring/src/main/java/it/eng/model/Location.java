package it.eng.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="locations")
public class Location {

	@Id
	@Column(name="locationcode")
	private String locationCode;
	private Double dailyPayment;
	private String countriesCountryCode;
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(String locationCode, Double dailyPayment, String countriesCountryCode) {
		super();
		this.locationCode = locationCode;
		this.dailyPayment = dailyPayment;
		this.countriesCountryCode = countriesCountryCode;
	}

	public String getLocationCode() {
		return locationCode;
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

	public String getCountriesCountryCode() {
		return countriesCountryCode;
	}

	public void setCountriesCountryCode(String countriesCountryCode) {
		this.countriesCountryCode = countriesCountryCode;
	}

	@Override
	public String toString() {
		return "Location [locationCode=" + locationCode + ", dailyPayment=" + dailyPayment + ", countriesCountryCode="
				+ countriesCountryCode + "]";
	}
	
	
	
	
	
}

