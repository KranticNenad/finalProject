package it.eng.model;
public class LoginM {

	String status;
	String auth;
	String userName;
	
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAuth() {
		return this.auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "LoginM [status=" + this.status + ", auth=" + this.auth + ", userName=" + this.userName + "]";
	}
}