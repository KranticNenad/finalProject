package it.eng.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Cars {

	/*
	 * regno VARCHAR2(10) NOT NULL, travelledkm NUMBER(8,2) NOT NULL, avgfueluse
	 * NUMBER(3,1) NOT NULL, isinuse NUMBER DEFAULT 0 NOT NULL, model VARCHAR2(20)
	 * NOT NULL
	 */

	@Id
	private String regno;

	private Double travelledkm;
	private Double avgfueluse;
	private Boolean isinuse;
	private String model;

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public Double getTravelledkm() {
		return travelledkm;
	}

	public void setTravelledkm(Double travelledkm) {
		this.travelledkm = travelledkm;
	}

	public Double getAvgfueluse() {
		return avgfueluse;
	}

	public void setAvgfueluse(Double avgfueluse) {
		this.avgfueluse = avgfueluse;
	}

	public boolean isIsinuse() {
		return isinuse;
	}

	public void setIsinuse(boolean isinuse) {
		this.isinuse = isinuse;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	

	public Cars(String regno, Double travelledkm, Double avgfueluse, boolean isinuse, String model) {
		super();
		this.regno = regno;
		this.travelledkm = travelledkm;
		this.avgfueluse = avgfueluse;
		this.isinuse = isinuse;
		this.model = model;
	}
	
	

	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		Cars other = (Cars) obj;
		if (regno == null) {
			if (other.regno != null) {
				return false;
			}
		}
		if (travelledkm == null) {
			if (other.travelledkm != null) {
				return false;
			}
		}
		if (avgfueluse == null) {
			if (other.avgfueluse != null) {
				return false;
			}
		}
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		}
		if (isinuse == null) {
			if (other.isinuse != null) {
				return false;
			}
		}

		return true;
	}

}
