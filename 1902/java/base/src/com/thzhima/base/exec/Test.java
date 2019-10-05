package com.thzhima.base.exec;

public class Test {

	static  int a() {
		try {
			int c= 1/0;
			return 1;
		}
		catch(Exception ex) {
			return 20;
		}
		finally {
			return 10;
		}
	}
	

	
	public static void main(String[] args) {
		System.out.println(a());
	}
	
}
