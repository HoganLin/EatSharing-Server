package com.pojo;

import java.util.Date;

public class CommentList {
	private Integer coid;

    private String userId;

    private String content;

    private Date createTime;

    private Integer sort;

    private String mainId;
    
    private String username;
    
    private String hphoto;

	public Integer getCoid() {
		return coid;
	}

	public void setCoid(Integer coid) {
		this.coid = coid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHphoto() {
		return hphoto;
	}

	public void setHphoto(String hphoto) {
		this.hphoto = hphoto;
	}
}
