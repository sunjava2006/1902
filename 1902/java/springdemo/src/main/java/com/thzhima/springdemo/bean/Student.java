package com.thzhima.springdemo.bean;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class Student {

	@Lookup("javaBook")
	public abstract Book mkBook();
	 
	 public void readBook() {
		 Book  book = this.mkBook();
		 System.out.println("我看的书是："+book);
	 }
}
