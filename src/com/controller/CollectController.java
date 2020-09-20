package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.CollectService;

@Controller
public class CollectController {
	
	@Autowired
	private CollectService collectService;
	
	@RequestMapping("/checkCollect")
	@ResponseBody
	public String checkCollect(String uid,String collectId) {
		int u = collectService.checkCollect(uid, collectId);
		return String.valueOf(u);
	}
	
	@RequestMapping("/setCollect")
	@ResponseBody
	public String setCollect(String uid,String sort,String collectId) {
		int s = Integer.valueOf(sort);
		int u = collectService.setCollect(uid, s, collectId);
		return String.valueOf(u);
	}
	
}
