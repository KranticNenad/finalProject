package it.eng.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Object to bind to database table using JPA (Hibernate) via annotations
@Entity
@Table(name = "warrants")
public class Warrant {

	/*
	 * issuedat DATE NOT NULL, distance NUMBER(6,2) NOT NULL, users_username
	 * VARCHAR2(16) NOT NULL, returnedat DATE, fuelused NUMBER(5,2), cars_regno
	 * VARCHAR2(10) NOT NULL, employees_employeeid NUMBER(13) NOT NULL
	 */

	/*
	 * Embeddable inner static class that will act as composite primary key for
	 * warrants table
	 */
	@Embeddable
	public static class WarrantPK implements Serializable {
		private static final long serialVersionUID = 1L;
		// here go the foreign keys that make up the composite primary key
		protected String cars_regno;
		protected String employees_employeeid;

		public WarrantPK() {
		}

		public WarrantPK(String cars_regno, String employees_employeeid) {
			this.cars_regno = cars_regno;
			this.employees_employeeid = employees_employeeid;
		}

		@Override
		public String toString() {
			return "WarrantPK [cars_regno=" + cars_regno + ", employees_employeeid=" + employees_employeeid + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			WarrantPK other = (WarrantPK) obj;
			if (cars_regno == null) {
				if (other.cars_regno != null) {
					return false;
				}
			}
			if (employees_employeeid == null) {
				if (other.employees_employeeid != null) {
					return false;
				}
			}
			if (!cars_regno.equals(other.cars_regno)) {
				return false;
			}
			if (!employees_employeeid.equals(other.employees_employeeid)) {
				return false;
			}
			return true;
		}
	}

	// EmbeddedId that calls inner static class and acts as composite key
	@EmbeddedId
	private WarrantPK warrantPK;
	@Column(name = "issuedat")
	private Date issuedAt;
	private Double distance;
	// defines the many side of the manyToOne relationship
	@ManyToOne()
	@JoinColumn(name = "users_username")
	private String issuedBy;
	@Column(name = "returnedat")
	private Date returnedAt;
	@Column(name = "fuelused")
	private Double fuelUsed;

	// Constructor with no arguments
	public Warrant() {
	}

	// Constructor with arguments
	public Warrant(WarrantPK warrantPK, Date issuedAt, Double distance, String issuedBy, Date returnedAt,
			Double fuelUsed) {
		this.warrantPK = warrantPK;
		this.issuedAt = issuedAt;
		this.distance = distance;
		this.issuedBy = issuedBy;
		this.returnedAt = returnedAt;
		this.fuelUsed = fuelUsed;
	}

	// getters and setters
	public WarrantPK getWarrantPK() {
		return warrantPK;
	}

	public void setWarrantPK(WarrantPK warrantPK) {
		this.warrantPK = warrantPK;
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

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
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
		return "Warrant [warrantPK=" + warrantPK + ", issuedAt=" + issuedAt + ", distance=" + distance + ", issuedBy="
				+ issuedBy + ", returnedAt=" + returnedAt + ", fuelUsed=" + fuelUsed + "]";
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
		if (warrantPK == null) {
			if (other.warrantPK != null) {
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
		if (issuedBy == null) {
			if (other.issuedBy != null) {
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
		if (!warrantPK.equals(other.warrantPK)) {
			return false;
		}
		if (!issuedAt.equals(other.issuedAt)) {
			return false;
		}
		if (!distance.equals(other.distance)) {
			return false;
		}
		if (!issuedBy.equals(other.issuedBy)) {
			return false;
		}
		if (!returnedAt.equals(other.returnedAt)) {
			return false;
		}
		if (!fuelUsed.equals(other.fuelUsed)) {
			return false;
		}
		return true;
	}

}
