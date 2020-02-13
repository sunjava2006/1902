package com.wangrui.mulitithread.sync;

public class BlockStatusDemo {

	private static Object mutex = new Object();
	
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		
		Thread t = new Thread() {
			public void run() {
				synchronized (mutex) {
					System.out.println("******************");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("*******************");
				}
			}
		};
		t.setPriority(Thread.MAX_PRIORITY);
		
		Thread t2 = new Thread() {
			public void run() {
				synchronized (mutex) {
					System.out.println("-----------------");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("------------------");
				}
			}
		};
		
		Thread moniterThread = new Thread(){
			public void run() {
				t2.start();
				t.start();
				while(true) {
					System.out.println("主线程状态：" + main.getState());
					System.out.println("t线程状态：" + t.getState());
					System.out.println("t2线程状态：" + t2.getState());
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		moniterThread.setDaemon(true);
		moniterThread.start();
		
		
		
		
		synchronized (mutex) {
			System.out.println("====================");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("=====================");
		}
		
				
		
	}
}
