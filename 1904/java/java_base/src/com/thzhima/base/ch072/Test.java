package com.thzhima.base.ch072;

import java.util.Date;

public class Test {

	static {
		System.out.println("Test static");
	}
	
	public static void main(String[] args) {
//		Human h = new Human();
//		h.name = "李中";
//		h.country = "外國";
//		h.gender = "男";
//		h.birthDate = new Date(1990-1900,0,1);
//		
//		System.out.println(h.name +"是" +h.country+"人."+"出生"+h.birthDate);
//		h.eat();
//		h.work();
//		
//		Student s = new Student();
//		s.name = "趙明";
//		s.gender = "男";
//		s.height = 1.82F;
//		System.out.println(s.name+"是"+s.country+"人");
//		s.eat();
//		s.work();
//		s.study();
		
//		Student s = null;
//		s = new Student("Xie", 123456);
//		System.out.println(s);
		
		Student s = new Student("wang","male",null);
		System.out.println(s.name);
		System.out.println(s.gender);
		System.out.println(((Human)s).name);
		
		s.work();
		
	}
}
