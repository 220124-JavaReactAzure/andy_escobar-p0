package com.revature.bank_app.util.datasource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	//singleton pattern to instantiating as soon as being defined (nothing else to happen)
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	//database authentication using db.properties
	private Properties prop = new Properties();
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			
			//not required used for testing for azure sql
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//constructor privatized 
	private ConnectionFactory() {
		
		// Using .properties for DB credentials (this is to obfuscate)
		try {
			
			//load the db.properties file
			prop.load(new FileReader("src/main/resources/db.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//return single instance of the connection factory object
	public static ConnectionFactory getInstance() {
		return connectionFactory;
	}
	
	public Connection getConnection() {
		Connection conn = null;//stablish some level of connection

		try {
			//get the connection and take sql drivers and get properties
			//dont want people to have acess 
			//make sure to put db.properties in your .gitignore!!!!!!
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("admin"),prop.getProperty("password"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;//return connection
	}
}
