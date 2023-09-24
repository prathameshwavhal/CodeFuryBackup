package com.oms.model;

import java.time.LocalDateTime;

public class Employee {
	private String empId;
	private String name;
	private LocalDateTime lastLogin;
	private boolean isLoggedIn;
	private String hashedPassword;

	public Employee(String empId, String name, LocalDateTime lastLogin, boolean isLoggedIn, String hashedPassword) {
		super();
		this.empId = empId;
		this.name = name;
		this.lastLogin = lastLogin;
		this.isLoggedIn = isLoggedIn;
		this.hashedPassword = hashedPassword;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	// no setter method for hashed password

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((hashedPassword == null) ? 0 : hashedPassword.hashCode());
		result = prime * result + (isLoggedIn ? 1231 : 1237);
		result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (hashedPassword == null) {
			if (other.hashedPassword != null)
				return false;
		} else if (!hashedPassword.equals(other.hashedPassword))
			return false;
		if (isLoggedIn != other.isLoggedIn)
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", lastLogin=" + lastLogin + ", isLoggedIn=" + isLoggedIn
				+ "]";
	}

}
