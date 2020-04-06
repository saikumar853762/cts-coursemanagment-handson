package com.ems.model;

public class EmployeeLogin {
	

	private String username;
	private String password;
	public EmployeeLogin() {
		super();
	}
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
	@Override
	public String toString() {
		return "EmployeeLogin [username=" + username + ", password=" + password + "]";
	}
	
	

}
