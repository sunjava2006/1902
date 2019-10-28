package com.thzhima.mvcblog.beans;

import java.io.Serializable;

public class User implements Serializable{

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", pwd=" + pwd + "]";
	}
	private Integer userID;
	private String userName;
	private String pwd;
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
	
	
}
