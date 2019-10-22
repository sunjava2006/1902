package com.thzhima.springdemo.proxy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
		
		MiddleSchoolStudent s = app.getBean(MiddleSchoolStudent.class);
		
		s.toSchool();
		System.out.println(s.getClass().getName());
		
		Teacher t = app.getBean(Teacher.class);
		t.toSchool();
		
		t.teach();
	}
}
