package com.thzhima;

public interface InterFace {

	public static void t() {
		return;
	}
	
	
	default void todo() {
		
//		System.out.println("----------");
	}
}

class Demo implements InterFace{
	
	{
		this.todo();
	}
	
}
