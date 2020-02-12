package com.wangrui.mulitithread.base;

public class VolatileDemo {

	public volatile static boolean flag = false;
	
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				while(true) {
					if(VolatileDemo.flag) {
						System.out.println("***************");
					}
				}
			}
		};
		t.start();
		
		// 将会改变flag的值
		Thread t2 = new Thread() {
			public void run() {
				VolatileDemo.flag = true;
				System.out.println("已经修改为"+ VolatileDemo.flag);
			}
		};
		t2.start();
		
	}
	
	
}
