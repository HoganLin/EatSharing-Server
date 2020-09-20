package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pojo.Food;
import com.pojo.FoodList;
import com.pojo.Recipe;
import com.pojo.RecipeList;
import com.pojo.User;
import com.service.CollectService;
import com.service.FoodService;
import com.service.RecipeService;
import com.service.UserService;

@Controller
public class RecommController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value ="/recipeRecomm",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String recipe_recomm() {
		List<Recipe> recipes = recipeService.getRecipes();
		List<RecipeList> list = new ArrayList<RecipeList>();
		if(recipes.size()!=0) {
			list = recipePackage(recipes);
			Map<String,Object> map = new HashMap<>();
			map.put("success",true);
			map.put("body",list);
			
			String jsonBody = JSON.toJSONString(map);
			System.out.println("---------------------------");
			System.out.println(jsonBody);
			return jsonBody;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value ="/foodRecomm",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String food_recomm() {
		List<Food> foods = foodService.getFoods();
		List<FoodList> list = new ArrayList<FoodList>();
		if(foods.size()!=0) {
			list = foodPackage(foods);
			Map<String,Object> map = new HashMap<>();
			map.put("success",true);
			map.put("body",list);
			
			String jsonBody = JSON.toJSONString(map);
			System.out.println("---------------------------");
			System.out.println(jsonBody);
			return jsonBody;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value ="/myRecipe",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String myRecipe(String username) {
		List<Recipe> recipes = recipeService.getMyRecipes(username);
		if(recipes.size()!=0) {
			Map<String,Object> map = new HashMap<>();
			map.put("success",true);
			map.put("body",recipes);
			
			String jsonBody = JSON.toJSONString(map);
			System.out.println("---------------------------");
			System.out.println(jsonBody);
			return jsonBody;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value ="/collectRecipe",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String collectRecipe(String username) {
		User user = userService.findUser(username);
		List<String> list = collectService.getRecipeIds(user.getUid());
		if(list.size()==0) {
			return null;
		}else {
			List<Recipe> recipes = recipeService.getCollectRecipes(list);
			List<RecipeList> recipeList = new ArrayList<RecipeList>();
			if(recipes.size()!=0) {
				recipeList = recipePackage(recipes);
				Map<String,Object> map = new HashMap<>();
				map.put("success",true);
				map.put("body",recipeList);
				
				String jsonBody = JSON.toJSONString(map);
				System.out.println("---------------------------");
				System.out.println(jsonBody);
				return jsonBody;
			}else {
				return null;
			}
		}
	}
	
	@RequestMapping(value ="/collectFood",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String collectFood(String uid) {
		List<String> list = collectService.getFoodIds(uid);
		if(list.size()==0) {
			return null;
		}else {
			List<Food> foods = foodService.getCollectFoods(list);
			List<FoodList> foodLists = new ArrayList<FoodList>();
			if(foods.size()!=0) {
				foodLists = foodPackage(foods);
				Map<String,Object> map = new HashMap<>();
				map.put("success",true);
				map.put("body",foodLists);
				
				String jsonBody = JSON.toJSONString(map);
				System.out.println("---------------------------");
				System.out.println(jsonBody);
				return jsonBody;
			}else {
				return null;
			}
		}
	}
	
	@RequestMapping(value ="/searchRecipe",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String searchRecipe(String key) {
		List<Recipe> recipes = recipeService.searchRecipes(key);
		List<RecipeList> recipeList = new ArrayList<RecipeList>();
		if(recipes.size()!=0) {
			recipeList = recipePackage(recipes);
			Map<String,Object> map = new HashMap<>();
			map.put("success",true);
			map.put("body",recipeList);
			
			String jsonBody = JSON.toJSONString(map);
			System.out.println("---------------------------");
			System.out.println(jsonBody);
			return jsonBody;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value ="/myFood",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String myFood(String username) {
		List<Food> foods = foodService.getMyFoods(username);
		if(foods.size()!=0) {
			Map<String,Object> map = new HashMap<>();
			map.put("success",true);
			map.put("body",foods);
			
			String jsonBody = JSON.toJSONString(map);
			System.out.println("---------------------------");
			System.out.println(jsonBody);
			return jsonBody;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value ="/deleteRecipe",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String deleteRecipe(String rid) {
		int u = recipeService.deleteRecipe(rid);
		return String.valueOf(u);
	}
	
	@RequestMapping(value ="/deleteFood",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String deleteFood(String fid) {
		int u = foodService.deleteFood(fid);
		return String.valueOf(u);
	}
	
	private List<RecipeList> recipePackage(List<Recipe> recipes){
		List<RecipeList> list = new ArrayList<RecipeList>();
		for(Recipe recipe : recipes) {
			User user = userService.findUserByUid(recipe.getUid());
			RecipeList item = new RecipeList();
			item.setRid(recipe.getRid());
			item.setCover(recipe.getCover());
			item.setTitle(recipe.getTitle());
			item.setCreatetime(recipe.getCreatetime());
			item.setIngredients(recipe.getIngredients());
			item.setStep(recipe.getStep());
			item.setStepImg(recipe.getStepImg());
			item.setTips(recipe.getTips());
			item.setUid(recipe.getUid());
			item.setUsername(user.getUsername());
			item.setHphoto(user.getHphoto());;
			
			list.add(item);
		}
		return list;
	}
	
	private List<FoodList> foodPackage(List<Food> foods){
		List<FoodList> list = new ArrayList<FoodList>();
		for(Food food : foods) {
			User user = userService.findUserByUid(food.getUid());
			FoodList item = new FoodList();
			item.setFid(food.getFid());
			item.setFphoto(food.getFphoto());
			item.setTitle(food.getTitle());
			item.setMessage(food.getMessage());
			item.setCreatetime(food.getCreatetime());
			item.setTag(food.getTag());
			item.setCollect(food.getCollect());
			item.setUid(food.getFid());
			item.setUsername(user.getUsername());
			item.setHphoto(user.getHphoto());
			
			list.add(item);
		}
		return list;
	}
}
