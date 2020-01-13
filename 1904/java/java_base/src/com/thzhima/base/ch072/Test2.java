package com.thzhima.base.ch072;

public class Test2 {

	public static void main(String[] args) {
		Animal a = null;
		Dog dog = new Dog("大黄");
		Parrot p  = new Parrot();
		
		dog.eat();
		p.eat();
		p.eat(dog);
		
		p.speak();
		
		a = p;
//		a.speak();
			
	}
}
