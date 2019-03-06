package it.eng.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "warrants")
public class Warrants {

	/*
	 * issuedat DATE NOT NULL, distance NUMBER(6,2) NOT NULL, users_username
	 * VARCHAR2(16) NOT NULL, returnedat DATE, fuelused NUMBER(5,2), cars_regno
	 * VARCHAR2(10) NOT NULL, employees_employeeid NUMBER(13) NOT NULL
	 */

	private Date issuedat;
	private Double distance;
	private String users_username;
	private Date returnedat;
	private Double fuelused;
	private String cars_regno;

	public Date getIssuedat() {
		return issuedat;
	}

	public void setIssuedat(Date issuedat) {
		this.issuedat = issuedat;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getUsers_username() {
		return users_username;
	}

	public void setUsers_username(String users_username) {
		this.users_username = users_username;
	}

	public Date getReturnedat() {
		return returnedat;
	}

	public void setReturnedat(Date returnedat) {
		this.returnedat = returnedat;
	}

	public Double getFuelused() {
		return fuelused;
	}

	public void setFuelused(Double fuelused) {
		this.fuelused = fuelused;
	}

	public String getCars_regno() {
		return cars_regno;
	}

	public void setCars_regno(String cars_regno) {
		this.cars_regno = cars_regno;
	}

	public Warrants(Date issuedat, Double distance, String users_username, Date returnedat, Double fuelused,
			String cars_regno) {
		super();
		this.issuedat = issuedat;
		this.distance = distance;
		this.users_username = users_username;
		this.returnedat = returnedat;
		this.fuelused = fuelused;
		this.cars_regno = cars_regno;
	}

	public Warrants() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Warrants [issuedat=" + issuedat + ", distance=" + distance + ", users_username=" + users_username
				+ ", returnedat=" + returnedat + ", fuelused=" + fuelused + ", cars_regno=" + cars_regno + "]";
	}

}
