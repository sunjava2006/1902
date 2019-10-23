package com.thzhima.mvcblog.beans;

public class Blog {

	private Integer blogID;
	private Integer userID;
	private String blogName;
	private String photo;
	public Integer getBlogID() {
		return blogID;
	}
	public void setBlogID(Integer blogID) {
		this.blogID = blogID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Blog(Integer blogID, Integer userID, String blogName, String photo) {
		super();
		this.blogID = blogID;
		this.userID = userID;
		this.blogName = blogName;
		this.photo = photo;
	}
	public Blog() {

	}
	
	
}
