package com.thzhima.base.ch8.sta;

public class StaDemo {
	int a ;
	static int b = 90;
	
	static {
		System.out.println(b);
	}
	{
		System.out.println();
	}
	
	public static void print() {
//		System.out.println(StaDeom.this.a);不行
		StaDemo sd = new StaDemo();
		System.out.println(sd.a);
		System.out.println(StaDemo.b);
	}
	
	public static void main(String[] args) {
		StaDemo sd = new StaDemo();
//		StaDemo.print();
		System.out.println(sd.b);
//		System.out.println(sd.a);
		
		StaDemo sd2 = new StaDemo();
		sd2.b = 100;
		
		System.out.println(sd.b);
		
	}
}
