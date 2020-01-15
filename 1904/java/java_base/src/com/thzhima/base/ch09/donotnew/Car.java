package com.thzhima.base.ch09.donotnew;

public class Car {
	
	protected Car() {
		
	}
	
	public static Car createNew() {
		return new Car();
	}

	public void run() {
		System.out.println("-------- run ----");
	}
}
