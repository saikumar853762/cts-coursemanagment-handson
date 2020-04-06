package com.ems.business;

import com.ems.model.Employee;
import com.ems.model.EmployeeLogin;

public interface EmployeeBO {
	
	
	public int login(EmployeeLogin empLogin);  //1 or 2 or 3 or 4
	
	public int createEmployee(Employee employee);  // 1 already registered // 2 employee is registered 3 // someother problem
	
	public boolean updateSalary(String username, double salary);
	

}
