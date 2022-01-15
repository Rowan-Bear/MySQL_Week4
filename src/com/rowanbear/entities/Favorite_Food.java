package com.rowanbear.entities;

public class Favorite_Food {

	private String foodName;
	private String foodOrigin;
	private int foodID;
	
		public Favorite_Food(String foodName, String foodOrigin, int foodID) {
		this.setFoodName(foodName);
		this.setFoodOrigin(foodOrigin);
		this.setFoodID(foodID);
	}

	

	public String getFoodOrigin() {
		return foodOrigin;
	}

	public void setFoodOrigin(String foodOrigin) {
		this.foodOrigin = foodOrigin;
	}

	public int getFoodID() {
		return foodID;
	}

	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}



	public String getFoodName() {
		return foodName;
	}



	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	
	
}
