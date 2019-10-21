package com.thzhima.springdemo.bean;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class TodoImplements implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName() + "-------------执行中---------------");
		System.out.println(obj.getClass().getName());
		return null;
	}

}
