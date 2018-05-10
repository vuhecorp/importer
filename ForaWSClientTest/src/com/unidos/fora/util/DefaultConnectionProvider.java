package com.unidos.fora.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DefaultConnectionProvider implements ConnectionProvider {
	
	private static Connection connection;
	  String jndiName = null;   
	  
	  public DefaultConnectionProvider(String jndi) {    
	      jndiName = jndi;    
	  }  
	  
	public static Connection setConnectionProvider(String schema){
		if (schema == null) {
			schema = "UnidosHc";
		}
		
		String connectionUrl = "jdbc:mysql://localhost:3306/" + schema + "?autoReconnect=true&useSSL=false";
		connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionUrl, "****", "****");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return connection;
	}
	
	public static void closeConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}
	
	public static Connection getConnection() {
		return getConnection();
	}
	
}
