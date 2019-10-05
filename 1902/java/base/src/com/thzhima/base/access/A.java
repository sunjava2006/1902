package com.thzhima.base.access;

public class A {
	public String name = "wang";
	String gender = "男";
	protected int money   = 10000000;
	private int money2 = 100000;
	
	public String toString() {
		return "name:"+ this.name
				+"; gender:" + this.gender
				+"; money: " + this.money
				+"; money2: " + this.money2;
	}
	
}
