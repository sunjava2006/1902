package com.thzhima.base.ch7;

public class Variable {

	int age;
	
	{ // 語句塊
		System.out.println();
		age = 90;
	}
	
	Variable(){
		System.out.println("---------------");
		age = 100;
	}
	
	public int getAge() {
		return age;
	}
	
	public int nextAge() {
		return ++age;
	}
	
	public int after(int n) {
		int a = age+n;
		return a;
	}
	
	public void todo() {
		int a;// 局部變量不會缺省初始化。
		a = 0;
		Object o = null;
		int b;
//		System.out.println(b);不初始化，不能用。
		System.out.println("todo end----------");
	}
	
	public static void main(String[] args) {
		Variable v = new Variable();
		
		v.todo();
	}
}
