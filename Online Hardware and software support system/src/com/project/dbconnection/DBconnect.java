package com.project.dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnect {
	
public static Connection provideConnection() {
		
		Connection conn=null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/Online_Hardware_and_software_support_system";
		
		try {
			conn= DriverManager.getConnection(url,"root","123654789");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
