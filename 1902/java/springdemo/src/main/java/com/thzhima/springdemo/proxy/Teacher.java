package com.thzhima.springdemo.proxy;

import org.springframework.stereotype.Component;

@Component
public class Teacher {

	public void toSchool() {
		System.out.println("老师去学校");
	}
	
	@MyTransaction
	public void teach() {
		System.out.println("上课中..............");
	}
}
