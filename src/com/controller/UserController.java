package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/login",produces={"application/json;charset=utf-8;"})
	@ResponseBody
	public String login_r(String username,String password) {
		User user = userService.findUser(username);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				Boolean success = true;
				
				List<Object> list = new ArrayList<Object>();
				list.add(user);
				
				Map<String,Object> map = new HashMap<>();
				map.put("success",success);
				map.put("body",list);
				
				String jsonBody = JSON.toJSONString(map);
				
				return jsonBody;
			}
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("success",false);
		
		return JSON.toJSONString(map);
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(String username,String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		int u = 0;
		u = userService.addUser(user);
		
		return String.valueOf(u);
	}
	
	@RequestMapping(value ="/updateUserMsg")
	@ResponseBody
	public String updateUserMsg(String username,String sex,String birthday,String profession,String city,String introduction) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		User user = new User();
		user.setUsername(username);
		user.setSex(sex);
		try {
			user.setBirthday(simpleDateFormat.parse(birthday));
		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setBirthday(simpleDateFormat.parse(birthday));
		user.setProfession(profession);
		user.setCity(city);
		user.setIntroduction(introduction);
		int u = userService.updateUserMsg(user);
		return String.valueOf(u);
	}
	

}
