package com.wangrui.spring.aop.base.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class Moniter {

	@Around("execution(* com.wangrui.spring.aop.base.service.MyService.getGDP())")
	public Long betwen(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("----------开始");
		Long o = (Long) pjp.proceed();
		System.out.println(o);
		System.out.println("----------结束");
		return o;
	}
}
