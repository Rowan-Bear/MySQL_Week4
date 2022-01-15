package com.rowanbear.dao;
//connects to the favorite_food DB(.getConnection() is used to connect favorite_food_dao to the database so it can use the entitity and work with the methods in the Menu class.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

private final static String URL = "jdbc:mysql://localhost:3306/favorite_food";	
private final static String USERNAME = "root";
private final static String PASSWORD = "root";
private static Connection  connection;
private static DBConnection instance;

private DBConnection(Connection connection) {
	this.connection = connection;
}

public static Connection getConnection() {
	if (instance == null) {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			instance = new DBConnection(connection);
			System.out.println("Connection Successful");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return DBConnection.connection;
}
	
}
