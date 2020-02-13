package com.wangrui.spring.base.bean.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class CarFactoryTest extends TestCase {

	public void testCreatCar() {
//		CarFactory factory = new CarFactory();// 实例工厂
//		Car car = factory.createCar(); // 工厂方法
//		car.run();
		
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		Car car = app.getBean(Car.class);
		car.run();
		CarFactory factory = app.getBean(CarFactory.class);
		Car car2 = factory.createCar();
		car2.run();
		
	}
}
