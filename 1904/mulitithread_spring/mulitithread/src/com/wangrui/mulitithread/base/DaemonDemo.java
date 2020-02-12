package com.wangrui.mulitithread.base;

public class DaemonDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {
				Thread t = new Thread() {
					public void run() {
						while(true) {
							System.out.println("---守护线程创建的线程------------"+ this.isDaemon());
						}
					}
				};
				t.start();
				while(true) {
					System.out.println("===================");
				}
			}
		};
		t.setDaemon(true); // 设置为守护线程
		
		t.start();
		
		Thread.sleep(2000);
		System.out.println("------------end");
	}
}
