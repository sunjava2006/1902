package com.thzhima.base.ch072;

public class Dog extends Animal{

	String name;
	
	public Dog() {
		
	}
	
	public Dog(String name) {
		this.name = name;
	}
	
	@Override
	public void eat() {
		System.out.println("吃骨头");
	}
	
	
}

class Parrot extends Animal{
	@Override
	public void run() {
		System.out.println("飞动中");
	}
	
	public void speak() {
		System.out.println("学说话");
	}
	
	public void eat(Object o) {
		System.out.println("吃"+o);
	}
}
