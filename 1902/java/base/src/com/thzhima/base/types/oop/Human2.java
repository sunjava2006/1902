package com.thzhima.base.types.oop;

public class Human2 {

	public String name;
	
	public final String GENDER ;
	
	// 构造方法
	public Human2(String gender, String name) {
		this.name = name;
		this.GENDER = gender;
	}
	
	
	public Human2() {
		this.GENDER = "male";
	}
	
	public Human2(String gender) {
		this.GENDER = gender;
	}
	/**
	 * 方法重载：方法名相同，但是参数列表不同。就构成方法的重载。与返回类型无关。
	 * 是多态的一种：编译时多态。
	 * 多态：指一个对外界面（接口），有多个不同实现。
	 */
	
	
	// 变通方法 
	public void work() {
		System.out.println(this.name + " is working now.");
	}
	
	public int work(Object o) {
		System.out.println("使用对象"+o+"完成工作");
		return 100;
	}
	
	public static void main(String[] args) {
		Human2 h = new Human2();
		Human2 h2 = new Human2("female", "Wang");
		h.work();
		h.work(new Object());
	}
}
