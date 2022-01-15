package com.rowanbear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rowanbear.entities.Favorite_Food;

public class favorite_food_dao {
	
	private Connection connection;
	//these are all the SQL commands used in the menu 
	private final String GET_FOOD_QUERY = "SELECT * FROM favorite_food";
	private final String CREATE_NEW_FOOD_QUERY = "INSERT INTO favorite_food(food_name, food_origin, food_id) VALUES(?, ?, ?)";
	private final String UPDATE_EXISTING_FOOD_QUERY = "UPDATE favorite_food SET food_name = ?, food_origin = ?, food_id = ? WHERE food_id = ?";
	private final String DELETE_FOOD_QUERY = "DELETE FROM favorite_food WHERE food_name = ?"	;	
	
	public favorite_food_dao() {
		 connection = DBConnection.getConnection();
	}
	//for display/Read method in menu
	public List<Favorite_Food> getFoods() throws SQLException {
		ResultSet rs = 		connection.prepareStatement(GET_FOOD_QUERY).executeQuery();
		List<Favorite_Food> Foods = new ArrayList<Favorite_Food>();
		
		while (rs.next()) {
			Foods.add(new Favorite_Food(rs.getString(1), rs.getString(2), rs.getInt(3)));
		}
		
		return Foods;
	}
	//for create method in menu
	public void createNewFood(String foodName, String foodOrigin, int foodId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_FOOD_QUERY);
		ps.setString(1, foodName);
		ps.setString(2, foodOrigin);
		ps.setInt(3, foodId);
		ps.executeUpdate();
	}
	//for update method in menu
	public void updateFood(String foodName, String foodOrigin, int newFoodId, int oldFoodId) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(UPDATE_EXISTING_FOOD_QUERY);
		ps.setString(1, foodName);
		ps.setString(2, foodOrigin);
		ps.setInt(3, newFoodId);
		ps.setInt(4, oldFoodId);
		ps.executeUpdate();
	}
	// for delete method in menu
	public void deleteFood(String foodName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_FOOD_QUERY);
		ps.setString(1, foodName);
		ps.executeUpdate();
	}
	
}

