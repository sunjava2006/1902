package com.wangrui.mulitithread.base;

public class ThreadStatusDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t  = new Thread() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("---------------------");
					try {
						Thread.sleep(1);// 当前执行线程休眠1秒 timed_waiting
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}  // terminated
		};
		System.out.println(t.getState());// new
		t.start(); // runnable
		
		for(int i=0;i<30;i++) {
			System.out.println(t.getState());
			System.out.println(t.isAlive());// 判断线程是否终结。
			Thread.sleep(1);
		}
		
	}
}
