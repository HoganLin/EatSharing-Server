package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.FollowMapper;
import com.pojo.Follow;
import com.pojo.FollowExample;
import com.pojo.FollowExample.Criteria;
import com.service.FollowService;

@Service
public class FollowServiceImpl implements FollowService{
	
	@Autowired
	private FollowMapper followMapper;
	
	@Override
	public int checkFollow(String uid, String uid_ed) {
		FollowExample example = new FollowExample();
		Criteria cri = example.createCriteria();
		cri.andUidUserEqualTo(uid);
		cri.andUidEdEqualTo(uid_ed);
		List<Follow> list = followMapper.selectByExample(example);
		if(list.size()!=0) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public int setFollow(String uid, String uid_ed) {
		int u = checkFollow(uid, uid_ed);
		if(u==1) {
			FollowExample example = new FollowExample();
			Criteria cri = example.createCriteria();
			cri.andUidUserEqualTo(uid);
			cri.andUidEdEqualTo(uid_ed);
			int d = followMapper.deleteByExample(example);
			if(d==1) {
				return 3;
			}else {
				return 2;
			}
		}else {
			Follow follow = new Follow();
			follow.setUidUser(uid);
			follow.setUidEd(uid_ed);
			try {
				return followMapper.insert(follow);
			} catch (Exception e) {
				return -1;
			}
		}
	}
	
	
	@Override
	public List<String> getFollowIds(String uid) {
		List<String> list = followMapper.selectUidedByUid(uid);
		return list;
	}
	
	@Override
	public int countFollow(String uid) {
		FollowExample example = new FollowExample();
		Criteria cri = example.createCriteria();
		cri.andUidUserEqualTo(uid);
		
		return followMapper.countByExample(example);
	}

}
