package com.thzhima.advance.thread;

public class BgThread {

	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		
		Thread t = new Thread() {
			public void run() {
				while(true) {
					System.out.println(main.getState());
				}
				
			}
		};
		t.setDaemon(true); // 将这个线程设置为Daemon线程
		t.start();
		
		for(int i=0;i<100;i++) {
			System.out.println("----------");
		}
		
		
	}
}
