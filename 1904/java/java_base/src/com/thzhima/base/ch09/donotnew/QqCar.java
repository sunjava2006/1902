package com.thzhima.base.ch09.donotnew;

public class QqCar extends Car{
	
	public static Car createNew() {
		return new QqCar();
	}

	public void run() {
		System.out.println("===================");
	}
}
