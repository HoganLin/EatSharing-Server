package com.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.FoodMapper;
import com.pojo.Food;
import com.pojo.FoodExample;
import com.pojo.FoodExample.Criteria;
import com.pojo.User;
import com.service.FoodService;
import com.service.UserService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodMapper foodMapper;
	
	@Autowired
	private UserService userService;
	
	@Override
	public int addFood(Food food, String username) {
		food.setFid(UUID.randomUUID().toString());
		User user = userService.findUser(username);
		food.setUid(user.getUid());
		food.setCreatetime(new Date());
		
		int u = foodMapper.insert(food);
		
		return u;
	}
	
	@Override
	public List<Food> getFoods() {
		List<Food> foods = foodMapper.selectByTime();
		return foods;
	}

	@Override
	public List<Food> getMyFoods(String username) {
		User user = userService.findUser(username);
		FoodExample example = new FoodExample();
		Criteria cri = example.createCriteria();
		cri.andUidEqualTo(user.getUid());
		List<Food> foods = foodMapper.selectByExample(example);
		return foods;
	}
	
	@Override
	public List<Food> getCollectFoods(List<String> list) {
		FoodExample example = new FoodExample();
		Criteria cri = example.createCriteria();
		cri.andFidIn(list);
		List<Food> foods = foodMapper.selectByExample(example);
		return foods;
	}
	
	@Override
	public int deleteFood(String fid) {
		int u = foodMapper.deleteByPrimaryKey(fid);
		return u;
	}
	
	@Override
	public int updateFood(Food food) {
		int u = foodMapper.updateByPrimaryKeySelective(food);
		return u;
	}
	
}
