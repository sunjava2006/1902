package com.thzhima.base.ch7;

public class Test {

	public static void main(String[] args) {
		// 申明 类型的对象 = 创建对象。
		Car car = new Car();
		System.out.println(car.brand); //访问对象的属性
		System.out.println(car.color);
		car.color = "Red"; // 修改对象的属性。
		System.out.println(car.color);
		car.run(); // 调用对象的方法。
		car.turn("left");
		car.stop();
//		car.adjust();
		
		
		AutoCar c = new AutoCar("qq1234567VK", "QQ", "red");
		System.out.println(c.brand + c.sid + c.color +c.weight+ c.speed);
		
		AutoCar c2 = new AutoCar("qq3456789JK","QQ");
		System.out.println(c2.brand + c2.sid + c2.color +c2.weight+ c2.speed);
		
		AutoCar c3 = new AutoCar();
		
	}
}
