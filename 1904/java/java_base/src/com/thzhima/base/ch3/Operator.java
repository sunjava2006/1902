package com.thzhima.base.ch3;

public class Operator {
	public static void main(String[] args) {
		Object o = new Object();
		String o2 = new String();
		System.out.println(o == o2);
		System.out.println(1==1);
		System.out.println("dfdf"!="dfdfdf");
		
		System.out.println("abc".compareTo("abc"));
		
		System.out.println(1==1 || false);
		
		System.out.println(o2 instanceof String);
//		System.out.println(typeof o2);
	}

}
