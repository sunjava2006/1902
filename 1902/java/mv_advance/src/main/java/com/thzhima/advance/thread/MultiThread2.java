package com.thzhima.advance.thread;

public class MultiThread2 {

	public static void main(String[] args) {
		
		//  接口，线程体接口方法
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				System.out.println("WangYing");
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		
		Thread t =  new Thread(runner);
		t.start();
	}
}
 