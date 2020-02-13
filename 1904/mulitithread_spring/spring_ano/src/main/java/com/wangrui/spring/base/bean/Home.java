package com.wangrui.spring.base.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Home {

	@Autowired(required = true)
	private Table table;
	
	@Autowired
	@Qualifier(value = "people")
	private People p;

	public People getP() {
		return p;
	}

	public void setP(People p) {
		this.p = p;
	}

	public Table getTable() {
		return table;
	}

	
//	public void setTable(Table table) {
//		this.table = table;
//	}

	@Override
	public String toString() {
		return "Home [p=" + p + ", table="+ table + "]";
	}
	
	
	
}
