package com.wangrui.spring.base.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Table {

	@Value("8仙桌")
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Table [model=" + model + "]";
	}
	
	
	
	
}
