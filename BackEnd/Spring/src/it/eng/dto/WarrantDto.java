package it.eng.dto;

import java.util.Date;
import java.util.List;

public class WarrantDto {
	private Long warrantId;
	private Date issuedAt;
	private Double distance;
	private Date returnedAt;
	private Double fuelUsed;
	private String regNo;
	private Long employeeId;
	private List<String> locationCodes;
	private String username;
	public Long getWarrantId() {
		return warrantId;
	}
	public void setWarrantId(Long warrantId) {
		this.warrantId = warrantId;
	}
	public Date getIssuedAt() {
		return issuedAt;
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
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public List<String> getLocationCodes() {
		return locationCodes;
	}
	public void setLocationCodes(List<String> locationCodes) {
		this.locationCodes = locationCodes;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
