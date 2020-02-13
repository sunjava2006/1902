package com.wangrui.mulitithread.sync;

public class NotifiedDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Object schema = new Object();// 关心货架的状态的改变
		
		Thread c = new Thread() {
			public void run() {
				try {
					synchronized (schema) {
						schema.wait(1000*30);// 30秒
					}
					System.out.println("买电脑");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		c.start();
		
		Thread.sleep(1000);// 让 c 线程先运行起来。
		
		synchronized (schema) { // wait和notify这两个方法，都必须先获取“监示器锁”
			Thread.sleep(3000);
			schema.notifyAll();//
			System.out.println("发出通知");
		}
		
		
		
	}
}
