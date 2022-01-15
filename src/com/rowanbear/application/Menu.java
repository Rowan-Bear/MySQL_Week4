package com.rowanbear.application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.rowanbear.dao.favorite_food_dao;
import com.rowanbear.entities.Favorite_Food;

public class Menu {
	//connects menu to DB
	private favorite_food_dao favorite_food_dao = new favorite_food_dao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Favorite Foods", 
			"Create Favorite Food", 
			"Update Favorite Food",
			"Delete Favorite Food");
			

	public void start() {
		String selection  = "";
		
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
			
			if (selection.equals("1")) {
				displayFavoriteFoods();
			}
			else if (selection.equals("2")) {
				createFavoriteFood();
			}
			else if (selection.equals("3")) {
				updateFavoriteFood();
			}
			else if (selection.equals("4")) {
				deleteFavoriteFood();
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
		}
			
			System.out.println("Press enter to continue..............");
			scanner.nextLine();
			
		} while(!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select An Option:\n-----------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	//Read
	private void displayFavoriteFoods() throws SQLException {
		List<Favorite_Food> foods = favorite_food_dao.getFoods();
		for (Favorite_Food food : foods) {
			System.out.println(food.getFoodName() + ": " + food.getFoodOrigin() + ": " + food.getFoodID());
		}
	}
	//Create
	private void createFavoriteFood() throws SQLException {
		System.out.println("Enter name of food: ");
		String foodName = scanner.nextLine();
		System.out.println("Enter where the food came from: ");
		String foodOrigin = scanner.nextLine();
		System.out.println("Enter the foodID");
		int foodId = Integer.parseInt(scanner.nextLine());
		favorite_food_dao.createNewFood(foodName, foodOrigin, foodId); 
	}
	//Update
	private void updateFavoriteFood() throws SQLException {
		System.out.println("Changed your mind?\n-------------------------\n" + "Enter the name of the new food: ");
		String foodName = scanner.nextLine();
		System.out.println("Enter where the new food came from: ");
		String foodOrigin = scanner.nextLine();
		System.out.println("Enter the new foodID");
		int newFoodId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter the food ID you would like to update: ");
		int oldFoodId = Integer.parseInt(scanner.nextLine());
		favorite_food_dao.updateFood(foodName, foodOrigin, newFoodId, 				oldFoodId);	
		}
	//Delete
	private void deleteFavoriteFood() throws SQLException {
		System.out.println("Changed your mind?\n------------------------\n" + "What's the name of the food you would like to delete?");
		String foodName = scanner.nextLine();
		favorite_food_dao.deleteFood(foodName);
	}
	
}
