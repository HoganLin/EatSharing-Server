package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.CollectMapper;
import com.pojo.Collect;
import com.pojo.CollectExample;
import com.pojo.CollectExample.Criteria;
import com.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService{
	
	@Autowired
	private CollectMapper collectMapper;
	
	@Override
	public int checkCollect(String uid, String collectId) {
		CollectExample example = new CollectExample();
		Criteria cri = example.createCriteria();
		cri.andCollectUidEqualTo(uid);
		cri.andCollectIdEqualTo(collectId);
		List<Collect> list = collectMapper.selectByExample(example);
		if(list.size()!=0) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public int setCollect(String uid, int sort, String collectId) {
		int u = checkCollect(uid, collectId);
		if(u==1) {
			CollectExample example = new CollectExample();
			Criteria cri = example.createCriteria();
			cri.andCollectUidEqualTo(uid);
			cri.andCollectIdEqualTo(collectId);
			int d = collectMapper.deleteByExample(example);
			if(d==1) {
				return 3;
			}else {
				return 2;
			}
		}else {
			Collect collect = new Collect();
			collect.setCollectUid(uid);
			collect.setCollectSort(sort);
			collect.setCollectId(collectId);
			try {
				return collectMapper.insert(collect);
			} catch (Exception e) {
				return -1;
			}
		}
	}
	
	@Override
	public List<String> getRecipeIds(String uid) {
		List<String> list = collectMapper.selectRecipeIdByUid(uid);
		return list;
	}
	
	@Override
	public List<String> getFoodIds(String uid) {
		List<String> list = collectMapper.selectFoodIdByUid(uid);
		return list;
	}
	
}
