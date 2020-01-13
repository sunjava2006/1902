package com.thzhima.base.ch8;

public class LiMingFactory {

	public Engine6 create() {
		return new Emei();
	}
	
	public static void main(String[] args) {
		LiMingFactory factory = new LiMingFactory();
		
		Engine6 engine = factory.create();
	}
}
