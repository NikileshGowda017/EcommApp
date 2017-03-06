package com.sakha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionManager1
{
	static String jdbcDriver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/Assignment1";
	static String username = "root";
	static String password = "root";
    static Connection con = null;
	public void connection() throws ClassNotFoundException, SQLException
	{
		Class.forName(jdbcDriver);
		con = DriverManager.getConnection(url,username,password);
		
	}
	
}
