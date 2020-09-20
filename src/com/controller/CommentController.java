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
import com.pojo.Comment;
import com.pojo.CommentList;
import com.pojo.User;
import com.service.CommentService;
import com.service.UserService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/addComment")
	@ResponseBody
	public String addComment(String username,String content,String sort,String main_id) {
		User user = userService.findUser(username);
		Comment comment = new Comment();
		comment.setUserId(user.getUid());
		comment.setContent(content);
		comment.setSort(Integer.valueOf(sort));
		comment.setMainId(main_id);
		int u = commentService.addComment(comment);
		return String.valueOf(u);
	}
	
	@RequestMapping(value ="/getComment",produces={"application/json; charset=utf-8;"})
	@ResponseBody
	public String getComment(String main_id) {
		List<Comment> comments = commentService.getComments(main_id);
		List<CommentList> list = new ArrayList<CommentList>();
		if(comments.size()!=0) {
			list = commentPackage(comments);
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
	
	private List<CommentList> commentPackage(List<Comment> comments){
		List<CommentList> list = new ArrayList<CommentList>();
		for(Comment comment: comments) {
			User user = userService.findUserByUid(comment.getUserId());
			CommentList item = new CommentList();
			item.setCoid(comment.getCoid());
			item.setUserId(comment.getUserId());
			item.setContent(comment.getContent());
			item.setCreateTime(comment.getCreateTime());
			item.setSort(comment.getSort());
			item.setMainId(comment.getMainId());
			item.setUsername(user.getUsername());
			item.setHphoto(user.getHphoto());
			
			list.add(item);
		}
		return list;
	}
}
