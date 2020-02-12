package com.wangrui.spring.base.bean;

public class ClearMan {

	private String name;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public ClearMan() {
		
	}

	public ClearMan(String name) {
		super();
		this.name = name;
	}


	public void clear() {
		System.out.println(this.name+"正在清洁中......");
	}
}
