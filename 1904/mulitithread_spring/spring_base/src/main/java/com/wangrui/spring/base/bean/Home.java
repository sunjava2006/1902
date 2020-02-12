package com.wangrui.spring.base.bean;

public class Home {

	private People people;

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Home(People people) {
		super();
		this.people = people;
	}

	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Home [people=" + people + "]";
	}
	
	
}
