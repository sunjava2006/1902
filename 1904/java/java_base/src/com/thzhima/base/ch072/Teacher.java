package com.thzhima.base.ch072;

public class Teacher extends Human {

	String subject;
	
	public void teach() {
		System.out.println("上课");
	}
	
	@Override
	public void work() {
		this.teach();
	}
}
