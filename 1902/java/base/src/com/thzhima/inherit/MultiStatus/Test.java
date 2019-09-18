package com.thzhima.inherit.MultiStatus;

import com.thzhima.inherit.Human;
import com.thzhima.inherit.Student;

public class Test {

	public static void main(String[] args) {
		Human h = null;
		
		int ran = (int)(Math.random()*10);
		if(ran%2 == 0 ) {
			h = new Student();
//			h.study();
			System.out.println(h);
			System.out.println((Student)h);
			System.out.println(h.name);
			Student s  = (Student)h;
			s.study();
			System.out.println(s.name);
		}else {
			h = new Human();
			System.out.println(h);
		}
		
		
	}
}
