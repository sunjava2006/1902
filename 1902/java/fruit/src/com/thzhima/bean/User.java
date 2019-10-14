package com.thzhima.bean;

public class User {

	private Integer ID;
	private String userName;
	private String pwd;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
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
	public User(Integer iD, String userName, String pwd) {
		super();
		ID = iD;
		this.userName = userName;
		this.pwd = pwd;
	}
	public User() {

	}
	
	
	
}
