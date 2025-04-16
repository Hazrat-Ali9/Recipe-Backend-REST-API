package com.android.recipe.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
	public static Connection con;
	public static Connection getConnection() {
		
		try {
			if(con==null || con.isClosed()) {
			    // Database credentials
			    String url = "jdbc:oracle:thin:@//localhost:1521/xe";
			    String user = "c##app_final";
			    String password = "root";

			    try {
			        // Establish connection
			    	try {
						Class.forName("oracle.jdbc.OracleDriver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			         con = DriverManager.getConnection(url, user, password);
			        System.out.println("Connected to Oracle Database 21c!");
			        // Close connection
//			        con.close();
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        return con;
	}
}
