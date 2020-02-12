package com.wangrui.mulitithread.base;

public class FirstMulitiThread {

	public static void main(String[] args) {
		// 获取当前运行的线程
		Thread t = Thread.currentThread();
		// 取线程名
		String name = t.getName();
		System.out.println("线程名为："+name);
		
		//================== 创建一个子线程，行运行 ======================
		Thread t2 = new Thread("t2子线程") {
			@Override
			public void run() {
				System.out.println("子线程是：" + Thread.currentThread().getName());
			}
		};
		t2.start();// 通知JVM创建一个线程，并立即执行，该线程的方法体（run方法）
		
		Thread t3 = new MyThread("t3线程");
		t3.start();
		
		
		System.out.println("----------- end --------------");
	}
}

class MyThread extends Thread{
	MyThread(String name){
		super(name);
	}
	@Override
	public void run() {
		System.out.println("当前子线程是："+Thread.currentThread().getName());
	}
}