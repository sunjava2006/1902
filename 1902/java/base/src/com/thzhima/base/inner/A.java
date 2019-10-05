package com.thzhima.base.inner;

public class A {

	void play() {
		System.out.println(" play..........");
	}
	
	static void todo() {
		System.out.println("----------------");
	}
	
	
	public static void main(String[] args) {
//		A a = new A() {
//			@Override
//			void play() {
//				System.out.println("play game.");
//			}
//	
//			
//		};
//		
//		
//		System.out.println(a instanceof A);
//		System.out.println(a.getClass().getName());
//		
//		a.play();
		
		A a = new B();
		a.todo();
		
		
	}
}

class B extends A{
	
//	@Override
	static void todo() {
		System.out.println("=============");
	}
}
