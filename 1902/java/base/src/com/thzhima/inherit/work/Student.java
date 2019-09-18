package com.thzhima.inherit.work;

public class Student extends Person {
	
	public String schoolName;
	public String major;
		
	public Student(String schoolName,String major,String gender) {
		super(gender);
		this.schoolName=schoolName;
		this.major=major;
		
	}
	
	public void study() {
		System.out.println(major+ "学习");
	}
	
	
}
