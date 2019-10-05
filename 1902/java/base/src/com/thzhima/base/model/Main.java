package com.thzhima.base.model;

public class Main {

	public static void main(String[] args) {
//		Car c = new Car("2.0", "red");
		
//		CarFactory factory = new CarFactory();
//		
//		Car c2 = factory.create("3.0", "green");
		
		Car c3 = CarFactory.create("40L", "black");
		
		Factory f = Factory.getInstance();
		Car c = f.create("A6l", "Block");
	}
}
