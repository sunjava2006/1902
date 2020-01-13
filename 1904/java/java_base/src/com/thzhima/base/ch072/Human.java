package com.thzhima.base.ch072;

import java.util.Date;

public class Human {
    private String msg;
	String name;
	Date birthDate;
	String gender;
	String country="中國";
	float height;
	float weight;
	
	private String getMsssage() {
		return this.msg;
	}
	
	static {
		System.out.println("Human static");
	}
	
	{
		System.out.println();
	}
	
	public Human(String gender, Date birthDate) {
		this.gender = gender;
		this.birthDate = birthDate;
	}
	
	public Human() {
		
	}
	
	public Human(String name, Date birthDate,String gender) {
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
	}
	
	public Human(String name, Date birthDate, String gender, 
			     String country, float height, float weight) {
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.country = country;
		this.height = height;
		this.weight = weight;
	}

	public void eat() {
		System.out.println(this.name+"吃飯中....");
	}
	
	protected void work() {
		System.out.println(this.name+"工作中....");
	}
}
