package com.thzhima.base.ch8;

public class CR929 {

	public static class ABC{
		String name = "LiMing";
	}
	
	public void run() {
		class Fire {
			{
				System.out.println("fire......");
			}
		}
		
		Fire fire = new Fire();
		
	}
	
//	Fire f = new Fire();
	
}
