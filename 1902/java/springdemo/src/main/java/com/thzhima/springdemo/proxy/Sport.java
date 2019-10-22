package com.thzhima.springdemo.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class Sport {
	
	@Before("execution(* com.thzhima.springdemo.proxy.MiddleSchoolStudent.toSchool(..))")
	public void run() {
		System.out.println("------------run-----------");
	}
	
	@Around("execution(* com.thzhima.springdemo..*.toSchool(..))")
	public void aroundRun(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("先跑一圈");
		pjp.proceed();
		System.out.println("再跑一圈");
	}
	@Before("@annotation(com.thzhima.springdemo.proxy.MyTransaction)")
	public void begin() {
		System.out.println("------------开始事务---------------");
	}
	
	@After("@annotation(com.thzhima.springdemo.proxy.MyTransaction)")
	public void end() {
		System.out.println("------------commit---------------");
	}
	@AfterThrowing("@annotation(com.thzhima.springdemo.proxy.MyTransaction)")
	public void exception() {
		System.out.println("------------rollback---------------");
	}
	@AfterReturning("@annotation(com.thzhima.springdemo.proxy.MyTransaction)")
	public void close() {
		System.out.println("------------close---------------");
	}
}
