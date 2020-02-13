package com.wangrui.spring.base.bean.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class TVFactoryTest extends TestCase {

	private ClassPathXmlApplicationContext app;
	
	protected void setUp() throws Exception {
		super.setUp();
		app = new ClassPathXmlApplicationContext("app.xml");
	}

	public void testCreateTV() {
//		TV tv = TVFactory.createTV();
//		tv.play();
		TV tv = app.getBean(TV.class);
		tv.play();
	}

	
	// 15 点继续课程，  现在是休息与练习时间。
	
	
	
}
