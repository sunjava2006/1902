package com.thzhima.base.ch072;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Human h = new Human();
		h.name = "李中";
		h.country = "外國";
		h.gender = "男";
		h.birthDate = new Date(1990,0,1);
		
		System.out.println(h.name +"是" +h.country+"人.");
		h.eat();
		h.work();
		
		Student s = new Student();
		s.name = "趙明";
		s.gender = "男";
		s.height = 1.82F;
		System.out.println(s.name+"是"+s.country+"人");
		s.eat();
		s.work();
		s.study();
		
	}
}
