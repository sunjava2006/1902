package com.wangrui.spring.base.bean.factory;

public class CarFactory {

	public Car createCar() {
		Car car = null;
		car = new Car("紅旗") {
		};
		return car;
	}
}
