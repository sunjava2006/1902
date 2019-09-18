package com.thzhima.base.types.oop.work;

import com.thzhima.base.types.oop.Human;

public class Dog {
	public String name;
	public int age;
	public final String GENDER;
	public static String def_name = "小狗";
	
	public Dog(String gender, int age, String name) {
		this.name = name;
		this.GENDER = gender;
		this.age = age;
	}
	
	public Dog(String gender) {
		this.GENDER = gender;
	}
	
	public static void sleep() {
		System.out.println(Dog.def_name + "sleep.");
		Dog d = new Dog("male");
		System.out.println(d.name);
	}
	
	public void eat(Food f) {
		System.out.println("小狗吃" +  f);
	}
	
	public void eat(Bone b) {
		System.out.println("小狗最喜欢吃的" +  b);
	}
	
	public void eat(Human h) {
		System.out.println("咬人啦。。。。。。");
	}
	
	
	public static void main(String[] args) {
		Dog wangWang = new Dog("male", 2, "大黄");
		
		wangWang.eat(new Bone());
		
		wangWang.eat(new Food());
	}
}
