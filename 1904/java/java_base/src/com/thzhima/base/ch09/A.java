package com.thzhima.base.ch09;

public class A {

	public static  String name = "wang";
	private static int money  = 90000000;
	protected static int lifeMoney = 100000;
	static int age = 30;
	
	public void about() {
		System.out.println(this.name+","+this.age+","+
	                       this.money+","+this.lifeMoney); 
	}
}
