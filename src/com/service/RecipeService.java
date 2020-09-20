package com.service;

import java.util.List;

import com.pojo.Recipe;

public interface RecipeService {
	int addRecipe(Recipe recipe,String username);
	
	List<Recipe> getRecipes();
	
	List<Recipe> getMyRecipes(String username);
	
	List<Recipe> getCollectRecipes(List<String> list);
	
	List<Recipe> searchRecipes(String key);
	
	int deleteRecipe(String rid);
	
	List<Recipe> getNormalRecipes(String fid);
	
	int updateRecipe(Recipe recipe);
}
