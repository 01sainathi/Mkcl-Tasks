package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	static final String Driver = "com.mysql.jdbc.Driver";
	static final String Url = "jdbc:mysql://localhost:3306/Assignments";
	static final String User = "root";
	static final String Pass = "root";
	static {
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(Url, User, Pass);
	}
}
