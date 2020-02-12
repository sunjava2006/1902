package com.wangrui.spring.base.bean;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class Chef implements MethodReplacer{
    private String name;
	public Chef(String name) {
		this.name = name;
	}
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println(this.name+ "在做饭。。。");
		return null;
	}

}
