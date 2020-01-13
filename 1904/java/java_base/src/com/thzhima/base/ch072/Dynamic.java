package com.thzhima.base.ch072;

public class Dynamic {

	public static void main(String[] args) {
		int ran = (int)(Math.random()*10);
		
		Human h = null;
		
		if(ran%2==0) {
			h =new Teacher();
		}
		else {
			h = new Student("wang",2334);
		}
		h.work();
		
		
		if(h instanceof Student) {
			System.out.println("is student");
			Student s = (Student)h;
			System.out.println(s.name);
		}
	}
}
