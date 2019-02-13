package edu.northeastern.cs5200;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://cs5200-fall2018-cui.c0sd5hknxfrk.us-east-2.rds.amazonaws.com/cs5200";
	private static final String USER = "jian";
	private static final String PASSWORD = "Cuijian1";

	public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
    	Class.forName(DRIVER);
    	return  DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static void closeConnection(java.sql.Connection conn) {
   	 try {
   		 conn.close();
   	 } catch (SQLException e) {
   		 // TODO Auto-generated catch block
   		 e.printStackTrace();
   	 }
	}
}

