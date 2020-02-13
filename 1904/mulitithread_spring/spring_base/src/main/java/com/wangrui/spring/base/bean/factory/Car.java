package com.wangrui.spring.base.bean.factory;

public abstract class Car {

	String brand;
	
	public void run() {
		System.out.println(brand + "车 run................");
	}
	
	public Car() {
		
	}
	
	public Car(String brand) {
		this.brand = brand;
	}
}
