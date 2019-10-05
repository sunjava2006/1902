package com.thzhima.base.model;

public class CarFactory {
	private CarFactory() {
		
	}
	
	public static Car create(String model, String color) {
		return new Car(model, color) {};
	}
}
