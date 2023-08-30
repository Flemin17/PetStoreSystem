package com.amdocs.petstore.dao;
import java.sql.Connection;

import java.sql.DriverManager;

public class DBConnection {
	
	public Connection getConnection() {
		
		Connection c = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //registration 
			c=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger");
		}catch(Exception e){
			System.out.println("Connection error");	
		}
	
		return c;
		
	}

}
