package com.wangrui.spring.base.bean;

public class Student {

	School school;
	private String name;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(School school) {
		
		this.school = school;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Student() {
		
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
	
}
