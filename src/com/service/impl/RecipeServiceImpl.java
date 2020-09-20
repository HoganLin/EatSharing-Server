package com.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.RecipeMapper;
import com.pojo.Recipe;
import com.pojo.RecipeExample;
import com.pojo.RecipeExample.Criteria;
import com.pojo.User;
import com.service.RecipeService;
import com.service.UserService;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeMapper recipeMapper;
	
	@Autowired
	private UserService userService;
	
	@Override
	public int addRecipe(Recipe recipe,String username) {
		recipe.setRid(UUID.randomUUID().toString());
		User user = userService.findUser(username);
		recipe.setUid(user.getUid());
		recipe.setCreatetime(new Date());
		
		int u = recipeMapper.insert(recipe);
		return u;
	}
	
	@Override
	public int updateRecipe(Recipe recipe) {
		int u = recipeMapper.updateByPrimaryKeySelective(recipe);
		return u;
	}
	
	@Override
	public List<Recipe> getRecipes() {
		List<Recipe> recipes = recipeMapper.selectByTime();
		return recipes;
	}
	
	@Override
	public List<Recipe> getMyRecipes(String username) {
		User user = userService.findUser(username);
		RecipeExample example = new RecipeExample();
		Criteria cri = example.createCriteria();
		cri.andUidEqualTo(user.getUid());
		List<Recipe> recipes = recipeMapper.selectByExample(example);
		return recipes;
	}
	
	@Override
	public List<Recipe> getCollectRecipes(List<String> list) {
		List<Recipe> recipes = recipeMapper.selectByIds(list);
		return recipes;
	}
	
	@Override
	public List<Recipe> searchRecipes(String key) {
		List<Recipe> recipes = recipeMapper.selectByKey(key);
		return recipes;
	}
	
	@Override
	public int deleteRecipe(String rid) {
		int u = recipeMapper.deleteByPrimaryKey(rid);
		return u;
	}
	
	@Override
	public List<Recipe> getNormalRecipes(String fid) {
		// TODO Auto-generated method stub
		return null;
	}

}
