package com.thzhima.base.ch8;

public class Test {


	public static void main(String[] args) {
		StaticDemo sd = new StaticDemo();
		
		System.out.println(sd.pi); // 实例变（常）量
		
		System.out.println(StaticDemo.PI); // 静态变（常）量
		
		System.out.println(StaticDemo.a(10));
		
		CR929.ABC abc = new CR929.ABC();
		
		C919.AJE8  arj8 = new C919().new AJE8(); 
		
	}
}
