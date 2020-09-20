package com.service;

import java.util.List;

import com.pojo.Food;

public interface FoodService {
	int addFood(Food food,String username);
	
	List<Food> getFoods();
	
	List<Food> getMyFoods(String username);
	
	List<Food> getCollectFoods(List<String> list);
	
	int deleteFood(String fid);
	
	int updateFood(Food food);
}
