package com.thzhima.base.exam;

public class Car extends Loader {

	public static final int MAX_LOAD = 3;
	
	public Car(int contain) {
		this.contain = contain;
	}

	public Car() {
		this.contain = 5;
	}
	
	@Override
	public void load() {
		System.out.println("car load....");
	}
	
	public void run() {
		System.out.println("run-------");
	}

}
