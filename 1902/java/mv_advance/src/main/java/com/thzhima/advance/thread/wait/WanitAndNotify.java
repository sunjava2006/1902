package com.thzhima.advance.thread.wait;

public class WanitAndNotify {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		
		
		Thread p = new Thread() {
			public void run() {
				
				try {
					synchronized (o) {
						o.wait();
					}
					System.out.println("---------激活------------");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		p.start();
		
		Thread.sleep(1000*3);
		synchronized (o) {
			System.out.println("=====通知====");
			o.notifyAll();
		}
		
	}
}
