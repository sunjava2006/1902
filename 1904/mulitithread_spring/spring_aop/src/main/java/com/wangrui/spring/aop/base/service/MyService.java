package com.wangrui.spring.aop.base.service;

import org.springframework.stereotype.Component;

@Component
public class MyService implements Service<String> {

	@Override
	public String service(int month) {
		
		return "Hello";
	}
	
	public Long getGDP() {
		return 2909090909L;
	}

}
