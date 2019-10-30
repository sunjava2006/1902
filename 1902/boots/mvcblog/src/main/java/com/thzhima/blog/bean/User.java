package com.thzhima.blog.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class User implements Serializable{

	
	private Integer userID;
	private String userName;
	private String pwd;
	private String email;
	private Blog blog; // 关联对象
	
	
	public User(Integer userID, String userName, String pwd, String email, Blog blog) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.pwd = pwd;
		this.email = email;
		this.blog = blog;
	}
	
	public User(Integer userID, String userName, String pwd, String email) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.pwd = pwd;
		this.email = email;
	}
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public User(Integer userID, String userName, String pwd) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.pwd = pwd;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", pwd=" + pwd + "]";
	}
	
	
}
