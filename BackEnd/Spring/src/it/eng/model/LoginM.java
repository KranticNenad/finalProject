package it.eng.model;

public class LoginM {

	String status;
	
	
	public String getStatus() {
		return this.status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Login [status=" + this.status + "]";
	}
	
}
