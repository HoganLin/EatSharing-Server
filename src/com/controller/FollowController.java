package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.FollowService;
import com.service.UserService;

@Controller
public class FollowController {

	@Autowired
	private FollowService followService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/checkFollow")
	@ResponseBody
	public String checkFollow(String uid,String uid_ed) {
		int u = followService.checkFollow(uid, uid_ed);
		return String.valueOf(u);
	}
	
	@RequestMapping("/setFollow")
	@ResponseBody
	public String setFollow(String uid,String uid_ed) {
		int u = followService.setFollow(uid, uid_ed);
		return String.valueOf(u);
	}
	
	@RequestMapping("/followCount")
	@ResponseBody
	public String followCount(String username) {
		User user = userService.findUser(username);
		int u = followService.countFollow(user.getUid());
		System.out.println("============"+u);
		return String.valueOf(u);
	}
	
	@RequestMapping(value ="/focusUser",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String getFocusUser(String uid_user) {
		List<String> idList = followService.getFollowIds(uid_user);
		System.out.println("---------------"+idList.size());
		if(idList.size()==0) {
			return null;
		}else {
			List<User> users = userService.findFocusUsers(idList);
			if(users.size()!=0) {
				Map<String,Object> map = new HashMap<>();
				map.put("success",true);
				map.put("body",users);
				
				String jsonBody = JSON.toJSONString(map);
				System.out.println("---------------------------");
				System.out.println(jsonBody);
				return jsonBody;
			}else {
				return null;
			}
		}
	}
	
}
