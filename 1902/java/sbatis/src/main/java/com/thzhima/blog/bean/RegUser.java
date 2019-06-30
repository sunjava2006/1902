package com.thzhima.blog.bean;

import java.io.Serializable;

public class RegUser implements Serializable{
	private Integer userID;
	private String regName;
	private String pwd;
	private String gender;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public RegUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegUser(Integer userID, String regName, String pwd, String gender) {
		super();
		this.userID = userID;
		this.regName = regName;
		this.pwd = pwd;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "RegUser [userID=" + userID + ", regName=" + regName + ", pwd=" + pwd + ", gender=" + gender + "]";
	}
	
	
}
