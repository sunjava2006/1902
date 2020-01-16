package com.thzhima.base.ch8;

import java.io.Serializable;

public class MyDreamImpl extends Engine6 implements MyDream,Serializable {

	@Override
	public void buyTicket() {
		System.out.println("buy ticket.");
	}

	@Override
	public void run() {
		System.out.println("----run----------");
		
	}

	
	
}
