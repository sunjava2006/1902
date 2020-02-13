package com.wangrui.spring.base.bean;

public class School {

	private Student student;
	
	public School(Student stu) {
		this.student = stu;
	}
	
	public School() {
		
	}
	
	public void setStudent(Student s) {
		this.student = s;
	}

	public Student getStudent() {
		return student;
	}

	@Override
	public String toString() {
		return "School [student=" + student + "]";
	}
	
}
