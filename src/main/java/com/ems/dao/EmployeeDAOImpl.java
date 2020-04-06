package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ems.model.Employee;

public class EmployeeDAOImpl implements EmployeeDao {

	@Override
	public Employee getEmployee(String username) {
          // null or employee
		// Select - 
		
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Employee emp = null;
		 
		 
		 try
		 {
			con = DataBaseConnection.getConn(); 
			
			 ps = con.prepareStatement("select * from employee where username=?");
			 
			  ps.setString(1, username);
			  
			  rs = ps.executeQuery();  // one or no rows //
			  
			  if(rs.next())
			  {
				  emp = new Employee();
				  
				  emp.setUsername(rs.getString(1));
				  emp.setFirstname(rs.getString(2));
				  emp.setLastname(rs.getString(3));
				  emp.setPassword(rs.getString(4));
				  emp.setEmail(rs.getString(5));
				  emp.setMobile(rs.getString(6));
				  emp.setSalary(rs.getDouble(7));
				  
				  emp.setStatus(rs.getString(8));
				  emp.setDateCreated(rs.getDate(9));
				  
			  }
			 
			 
		 }
		 catch (Exception e) {

   e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public boolean saveEmplyee(Employee employee) {
       // Connection // statement // query execute
         // 100 - 100 at 
		boolean status = false;
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try
		{
			con = DataBaseConnection.getConn();
			
			 ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?)");
			 
			 // 7 - double 
			 
			 // 9 date
			 
			 ps.setString(1,employee.getUsername());
			 ps.setString(2, employee.getFirstname());
			 ps.setString(3, employee.getLastname());
			 
			 ps.setString(4, employee.getPassword());
			 ps.setString(5, employee.getEmail());
			 ps.setString(6, employee.getMobile());
			 ps.setDouble(7, employee.getSalary());
			 
			 ps.setString(8, "no");
			 
			 ps.setDate(9, new java.sql.Date(employee.getDateCreated().getTime()));
			 
			int res = ps.executeUpdate();
			if(res == 1)
			{
				status = true;
			}
		}
		catch (Exception e) {

			
			 
          // e.printStackTrace();
			return status;
		}finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return status;
	}

	@Override
	public List<Employee> getEmployees() {

          // 
		
		List<Employee> empList = new ArrayList<Employee>();
		
		
		
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try
		{
			con = DataBaseConnection.getConn();
			
			st = con.createStatement();
			
			rs = st.executeQuery("select * from employee");
			
			while(rs.next())

			{
				Employee emp = new Employee();
				  
				  emp.setUsername(rs.getString(1));
				  emp.setFirstname(rs.getString(2));
				  emp.setLastname(rs.getString(3));
				  emp.setPassword(rs.getString(4));
				  emp.setEmail(rs.getString(5));
				  emp.setMobile(rs.getString(6));
				  emp.setSalary(rs.getDouble(7));
				  
				  emp.setStatus(rs.getString(8));
				  emp.setDateCreated(rs.getDate(9));
				  
				  empList.add(emp);
			}
			
			
		}catch (Exception e) {

         e.printStackTrace();
		}
		
		
		
		
		
		return empList;
	}

	@Override
	public boolean updateEmployee(String username, double salary) {

          // Update
		
		
		boolean st = false;
		
		Connection con= null;
		PreparedStatement ps = null;
		
		
		try
		{
			con = DataBaseConnection.getConn();
			ps = con.prepareStatement("update employee set status=? , salary=? where username=?");
			
			ps.setString(1, "yes");
			ps.setDouble(2, salary);
			ps.setString(3, username);
			
			int res = ps.executeUpdate();
			if(res ==1)
			{
				st= true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();

		}
		return st;
	}

}
