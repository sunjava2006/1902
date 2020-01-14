package com.thzhima.base.ch8;

public class AS {
	
	int a = 90;
	
	class Inner{
		int a = 99;
		
		public void print() {
			System.out.println(Inner.this.a);
			System.out.println(AS.this.a);
		}
	}

}
