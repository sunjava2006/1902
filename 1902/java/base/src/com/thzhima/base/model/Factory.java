package com.thzhima.base.model;

public class Factory {
	//单（实）例模式
//	private static  Factory  f = new Factory()  饱汉模式
	private static  Factory  f ; //饿汉模式

	private Factory() {
		
	}
	
	public static Factory getInstance() {
		if(f == null) {
			f = new Factory();
		}
		return f;
	}
	
	public  Car create(String model, String color) {
		return new Car(model, color) {};
	}
	
	
}
