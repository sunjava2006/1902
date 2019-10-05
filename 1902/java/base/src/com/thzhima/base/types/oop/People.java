package com.thzhima.base.types.oop;

public class People {
	String name ;
	int age ;
	boolean married;
	String country = "china";
	
	// 构造函数（构造方法）
	People(String n, int a, boolean m){
		name = n;
		age = a;
		married = m;
	}
	// 构造函数。（缺省操作）
	People(){
		
	}
	
	public static void main(String[] args) {
		People p = new People("Li", 30, true);
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.married);
		
		People p2 = new People("Huang", 19, false);
		System.out.println(p2.name);
		System.out.println(p2.age);
		System.out.println(p2.married);
		
		People p3 = new People();
		
		System.out.println(p instanceof People);
	}
}
