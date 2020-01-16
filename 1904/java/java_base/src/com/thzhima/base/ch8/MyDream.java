package com.thzhima.base.ch8;

public abstract interface MyDream {

	public static final long money = 999999999999999999L;
	
    public abstract void buyTicket();
    
    // JDK 8
    default void a() {
    	System.out.println("ddfddffd");
    	System.out.println(MyDream.money);
    }
}
