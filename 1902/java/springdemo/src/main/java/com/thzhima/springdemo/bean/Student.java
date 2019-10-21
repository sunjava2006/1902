package com.thzhima.springdemo.bean;

public abstract class Student {

	public abstract Book mkBook();
	 
	 public void readBook() {
		 Book  book = this.mkBook();
		 System.out.println("我看的书是："+book);
	 }
}
