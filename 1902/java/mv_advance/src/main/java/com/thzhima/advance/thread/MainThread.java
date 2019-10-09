package com.thzhima.advance.thread;

public class MainThread {

	public static void main(String[] args) {
		
		Thread current = Thread.currentThread();
		String threadName = current.getName();
		System.out.println(threadName);
		
		
		Thread t = new Thread("我的线程") {
			public void run() {
				System.out.println("------>>>>>>>>>---");
			}
		};
		
		t.start();
		String subThreadName = t.getName();
		System.out.println(subThreadName);
		
		
      Thread t2 = new Thread(){
			public void run() {
				System.out.println("==================");
				System.out.println( "name is:"+Thread.currentThread().getName());
			}
		};
		
		t2.start();
		String subThreadName2 = t2.getName();
		System.out.println(subThreadName2);
	}
}
