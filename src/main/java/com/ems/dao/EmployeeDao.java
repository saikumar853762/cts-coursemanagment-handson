package com.ems.dao;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeDao {

    public Employee getEmployee(String username);
    public boolean saveEmplyee(Employee employee);
    public List<Employee> getEmployees();
    
    public boolean updateEmployee(String username,double salary);
	
	

}
