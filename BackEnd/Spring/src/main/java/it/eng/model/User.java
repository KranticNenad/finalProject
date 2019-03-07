package it.eng.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	/* 
	 * sets username as the primary key for user and maps
	 * the one side of the manyToOne relationship
	 */
	@Id
	@Column(name = "username")
	@OneToMany(mappedBy = "issuedBy")
	private String username;
	private String password;
	private Boolean enabled;
	private String authority;
	private String email;

	// constructor with no arguments
	public User() {
	}

	// constructor with arguments
	public User(String username, String password, Boolean enabled, String authority, String email) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		this.email = email;
	}

	// getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// equals method implementation
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		User other = (User) obj;
		if (this.username == null) {
			if (other.username != null) {
				return false;
			}
		}
		if (this.password == null) {
			if (other.password != null) {
				return false;
			}
		}
		if (this.enabled == null) {
			if (other.enabled != null) {
				return false;
			}
		}
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		}
		if (this.authority == null) {
			if (other.authority != null) {
				return false;
			}
		}
		if (this.username != other.username) {
			return false;
		}
		if (this.password != other.password) {
			return false;
		}
		if (this.enabled != other.enabled) {
			return false;
		}
		if (this.authority != other.authority) {
			return false;
		}
		if (this.email != other.email) {
			return false;
		}
		return true;
	}
	
	// toString method implementation
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ", authority="
				+ authority + ", email=" + email + "]";
	}

}
