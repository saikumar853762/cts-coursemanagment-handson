package com.ems.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
@Entity
@Table(name = "emp123")
public class Employee {
	
	@Id
	@Generated("assigned")
	@Column
	private String username;
	@Column(name="fname")
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String mobile;
	@Column
	private double salary;
	@Column
	private Date dateCreated;
	@Column
	private String status;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		return "Employee [username=" + username + ", fisrtname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", email=" + email + ", mobile=" + mobile + ", salary=" + salary + ", dateCreated="
				+ dateformat.format(dateCreated) + ", status=" + status + "]";
	}
	
	
	
	

}
