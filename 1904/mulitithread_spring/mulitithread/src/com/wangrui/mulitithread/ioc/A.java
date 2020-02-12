package com.wangrui.mulitithread.ioc;

public class A {

	// 属性
	People p ;
	
	// 属性注入
	public void setPeople(People p) {
		this.p = p;
	}
	
	// 构造注入
	A(People p){
		this.p = p;
	}
}
