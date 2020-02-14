package com.wangrui.spring.base.service;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class AspectDemo {

	@Before("execution(* com.wangrui.spring.base.service.MyService.service())")
	public void before() {
		System.out.println("=====before====");
	}
}
