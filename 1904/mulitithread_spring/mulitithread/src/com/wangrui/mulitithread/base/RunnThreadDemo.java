package com.wangrui.mulitithread.base;

public class RunnThreadDemo {

	public static void main(String[] args) {
		// 实现 Runnable 接口
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		// 将实现传递给Thread 
		Thread t = new Thread(runner);
		t.start();
//		t.run(); 仅是变通的对象方法的调用。不会启动新的线程。
	}
}
