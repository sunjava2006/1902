package com.thzhima.springdemo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Room {

	@Autowired
	@Qualifier("pythonBook")
	private Book book;

	public Room(Book book) {
		super();
		this.book = book;
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Room [book=" + this.book + "]";
	}
	
	
}
