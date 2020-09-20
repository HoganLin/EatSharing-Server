package com.service;

import java.util.List;

public interface FollowService {
	int checkFollow(String uid,String uid_ed);
	
	int setFollow(String uid,String uid_ed);
	
	List<String> getFollowIds(String uid);
	
	int countFollow(String uid);
}
