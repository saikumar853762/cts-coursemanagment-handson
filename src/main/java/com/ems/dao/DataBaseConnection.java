package com.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	
	
	public static Connection getConn()
	{
		Connection con = null;
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vlems", "root", "root");
			
		}catch (Exception e) {

         e.printStackTrace();
		}
		
		return con;
	}

}
