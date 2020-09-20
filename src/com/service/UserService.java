package com.service;

import java.util.List;

import com.pojo.User;

public interface UserService {
	User findUser(String username);
	
	User findUserByUid(String uid);
	
	int addUser(User user);
	
	int updateHeadImg(String username,String hphoto);
	
	int updateUserMsg(User user);
	
	List<User> findFocusUsers(List<String> idList);
}
