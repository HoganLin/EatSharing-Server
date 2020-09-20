package com.service;

import java.util.List;

public interface CollectService {
	int checkCollect(String uid,String collectId);
	
	int setCollect(String uid,int sort,String collectId);
	
	List<String> getRecipeIds(String uid);
	
	List<String> getFoodIds(String uid);
}
