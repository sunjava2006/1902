package com.thzhima.base.ch7;

public class AutoCar {

	// 定义属性
	String sid;
	String brand;
	String color;
	float weight;
	float speed;

	// 构造函数 没有返回类型的申明，方法名与类名相同
	public AutoCar(String color, float weight) {
		this.color = color;
		this.weight = weight;
	}

	// 构造函数 没有返回类型的申明，方法名与类名相同
	public AutoCar(float speed, String brand) {
		this.speed = speed;
		this.brand = brand;
	}

	// 构造函数 没有返回类型的申明，方法名与类名相同
	public AutoCar(String sid, String brand, String color, float weight, float speed) {
		// 初始化属性值
		this.sid = sid;
		this.brand = brand;
		this.color = color;
		this.weight = weight;
		this.speed = speed;

	}

	public AutoCar() {

	}

	// 构造函数 没有返回类型的申明，方法名与类名相同
	public AutoCar(String sid, String brand, String color) {
		// 初始化属性值
		this.sid = sid;
		this.brand = brand;
		this.color = color;
	}

	// 构造函数 没有返回类型的申明，方法名与类名相同
	public AutoCar(String sid, String brand) {
		// 初始化属性值
		this.sid = sid;
		this.brand = brand;

	}

	// 定义方法
	public void run() {
		System.out.println(this.sid + "车，正在运行...");
	}

	public void stop() {
		System.out.println(this.sid + "停下来了。");
	}
}
