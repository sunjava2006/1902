package com.thzhima.base.ch8;

import java.io.Serializable;

public class TestInterface {

	public static void main(String[] args) {
		MyDream md = new MyDreamImpl();
		
		md.buyTicket();
		md.a();
		
		Serializable s = (Serializable)md;
		Engine6 e = (Engine6)md;
		e.run();
		e.fire();
		
	}
}
