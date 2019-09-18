package com.thzhima.inherit;

import java.sql.Date;

public class Human {
	
	public String name = "小李";
	public Date birthday;
	
	static{
		System.out.println("load Human");
	}
	
	{
		System.out.println("11");
	}
	
	public void work() {
		System.out.println(this.name + " is working now.");
	}
	
	public Human(String name, Date birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
	public Human() {
	  System.out.println(1);	
	}
	
	public String toString() {
		return "name:" + this.name+ "; birthday:"+this.birthday ;
	}
	
	public static void main(String[] args) {
		Human h = new Human("xx",new Date(2342343434l));
	}
}
