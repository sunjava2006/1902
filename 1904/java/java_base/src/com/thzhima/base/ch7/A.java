package com.thzhima.base.ch7;

public class A {

	
	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A();
		Object o = new Object();
		
		System.out.println(o.hashCode());
		System.out.println(o);
		System.out.println(a.hashCode());
		System.out.println(a);
		A aa = (A) a.clone();
		
		
	}
}
