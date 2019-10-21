package com.thzhima.springdemo.bean;

public class Factory {

	public static Car create() {
		return new Car() {};
	}
}
