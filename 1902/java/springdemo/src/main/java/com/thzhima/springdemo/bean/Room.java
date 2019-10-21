package com.thzhima.springdemo.bean;

public class Room {

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
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Room [book=" + book + "]";
	}
	
	
}
