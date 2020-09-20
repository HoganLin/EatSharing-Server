package com.service;

import java.util.List;

import com.pojo.Comment;

public interface CommentService {
	int addComment(Comment comment);
	
	List<Comment> getComments(String main_id);
}
