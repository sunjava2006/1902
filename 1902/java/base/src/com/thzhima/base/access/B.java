package com.thzhima.base.access;

public class B {

	A a = new A();
	
	public String aboutA() {
		return "a.name:" + a.name
				+"a.gender: " + a.gender
				+"a.money: " + a.money;
	}
}
