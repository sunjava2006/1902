package com.thzhima.base.interfaces;

public abstract class Bird extends Object
        implements Flyable, SingAble{
	
	public void sing() {
		System.out.println("sing a song");
	}
	
}
