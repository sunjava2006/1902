package com.wangrui.spring.base.bean.factory;

public abstract class TV {

	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public TV() {
		
	}

	public TV(String brand) {
		this.brand = brand;
	}
	
	public void play() {
		System.out.println(this.brand+" 在播放节目。。");
	}
}
