package com.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.CommentMapper;
import com.pojo.Comment;
import com.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public int addComment(Comment comment) {
		comment.setCreateTime(new Date());;
		int u = commentMapper.insert(comment);
		return u;
	}
	
	@Override
	public List<Comment> getComments(String main_id) {
		List<Comment> list = commentMapper.selectByTime(main_id);
		return list;
	}
	
}
