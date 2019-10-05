package com.thzhima.base.model;

public abstract class Car {
	String model;
	String color;
	
	
	
	public Car(String model, String color) {
		this.color = color;
		this.model = model;
	}
	
	public void run() {
		System.out.println("run..........");
	}
}
