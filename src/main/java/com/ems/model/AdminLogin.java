package com.ems.model;

public class AdminLogin {
	
	private String username;
	private String password;
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
	public AdminLogin() {
		super();
	}
	@Override
	public String toString() {
		return "AdminLogin [username=" + username + ", password=" + password + "]";
	}
	
	

}
