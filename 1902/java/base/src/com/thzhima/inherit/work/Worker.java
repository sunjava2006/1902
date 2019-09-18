package com.thzhima.inherit.work;

public class Worker extends Person {

	public String factoryName;
	public String prefession;
	
	public Worker(String gender) {
		super(gender);
	}
	
	public Worker(String gender, String farctoryName, String profession) {
		super(gender);
		this.factoryName = factoryName;
		this.prefession = profession;
	}
	
	public void work() {
		System.out.println(prefession + " 劳动中。");
	}
	
	
	
}
