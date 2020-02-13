package com.wangrui.spring.base.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Library {

//	@Value(value = "{c,java,python}")
	@Autowired
	private List<Book> bookNames;

	public List<Book> getBookNames() {
		return bookNames;
	}

	public void setBookNames(List<Book> bookNames) {
		this.bookNames = bookNames;
	}

	@Override
	public String toString() {
		return "Library [bookNames=" + bookNames + "]";
	}

	
	
	
}
