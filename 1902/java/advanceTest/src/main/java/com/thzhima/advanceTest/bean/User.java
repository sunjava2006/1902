package com.thzhima.advanceTest.bean;

public class User {
	private Integer ID;
	private String name;
	private String password;
	public User(Integer iD, String name, String password) {
		super();
		ID = iD;
		this.name = name;
		this.password = password;
	}
	public User() {

	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", name=" + name + ", password=" + password + "]";
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
