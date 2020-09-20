package com.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import com.pojo.UserExample.Criteria;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UserMapper userMapper;
	
	@Override
	public User findUser(String username) {
		UserExample  example = new UserExample();
		Criteria cri = example.createCriteria();
		cri.andUsernameEqualTo(username);
		List<User> list = null;
		list = userMapper.selectByExample(example);
		if(list.size()!=0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public int addUser(User user) {
		user.setUid(UUID.randomUUID().toString());
		UserExample  example = new UserExample();
		Criteria cri = example.createCriteria();
		cri.andUsernameEqualTo(user.getUsername());
		if(!userMapper.selectByExample(example).isEmpty()) {	
			return -1;
		}
		try {
			return userMapper.insert(user);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	@Override
	public int updateHeadImg(String username, String hphoto) {
		User user = findUser(username);
		user.setHphoto(hphoto);
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
	@Override
	public User findUserByUid(String uid) {
		User user = userMapper.selectByPrimaryKey(uid);
		return user;
	}
	
	@Override
	public int updateUserMsg(User user) {
		User user2 = findUser(user.getUsername());
		user2.setSex(user.getSex());
		user2.setBirthday(user.getBirthday());
		user2.setProfession(user.getProfession());
		user2.setCity(user.getCity());
		user2.setIntroduction(user.getIntroduction());
		return userMapper.updateByPrimaryKey(user2);
	}
	
	@Override
	public List<User> findFocusUsers(List<String> idList) {
		UserExample  example = new UserExample();
		Criteria cri = example.createCriteria();
		cri.andUidIn(idList);
		List<User> users = userMapper.selectByExample(example);
		return users;
	}
	
}
