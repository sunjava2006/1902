package com.thzhima.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thzhima.springdemo.bean.Book;
import com.thzhima.springdemo.bean.Car;
import com.thzhima.springdemo.bean.Room;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
		Book b1 = (Book)app.getBean("javaBook");
		System.out.println(b1);
		
		Book b2 = (Book) app.getBean("pythonBook");
		System.out.println(b2);
		
		
		Room r = app.getBean(Room.class);
		System.out.println(r);
		Room r2 = app.getBean(Room.class);
		System.out.println(r == r2);
		
//		Car c1 = (Car) app.getBean("car");
//		c1.run();
//		
//		Car c2 = (Car) app.getBean("car2");
//		c2.run();
	}

}
