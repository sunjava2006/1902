package com.thzhima.base.types.oop;

public class Human {
	
	// 实例变量、属性。
	public String name = "王";
	public int age;
	public final String gender;
	public static final String Country; // 静态变量。
	
	static{//静态块
		System.out.println();
		Country ="china";
	}
	
	{// 代码块
		System.out.println("-----------------------");
		this.name = "李";
//		this.gender = "x";
		
	}
	
	// 构造函数（构造方法）
	public Human(String gender, int age, String name) {
		this.gender = gender; // this表示当前对象
		this.age = age;
		this.name = name;
		System.out.println("=======================");
	}
	
	public void work() {
		System.out.println(this.name + " is working now.");
	}
	
	
	public static void main(String[] args) {
		Human liBai = new Human("male", 60, "李白");
		System.out.println(liBai.name);
//		
//		liBai.work();
	}

	
}
