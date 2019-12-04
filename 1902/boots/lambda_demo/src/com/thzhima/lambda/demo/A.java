package com.thzhima.lambda.demo;

public class A {

	public void thing(Todo t) {
		System.out.println(t.getClass().getName());
		System.out.println(t instanceof Todo);
		t.todo();
	}
	
	public static void main(String[] args) {
		A a = new A();
		a.thing(()->{System.out.println("hello");});
	}
	

}
