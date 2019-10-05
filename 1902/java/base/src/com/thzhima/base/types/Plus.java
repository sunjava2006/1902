package com.thzhima.base.types;

public class Plus {
	
	static boolean a() {
		System.out.println("a");
		return true;
	}
	
	static boolean b() {
		System.out.println("b");
		return false;
	}
	

	public static void main(String[] args) {
		if(b() & a()) {
			System.out.println("ok");
		}else {
			System.out.println("no");
		}
		
		if(a() | a()) {
			System.out.println("ok");
		}else {
			System.out.println("no");
		}
	}
}
