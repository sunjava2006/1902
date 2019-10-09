package com.thzhima.advance.thread;

public class MultiThread {

	public static void main(String[] args) {
		Thread t1 = new T1("tA");
		Thread t2 = new T2("tB");
		
//		t1.start();
//		t2.start();
//		t1.run(); 这个方法，不应该主动调用。应该是被子线程调用的。是子线程的执行体。
	}
}

class T1 extends Thread{
	T1(String name){
		super(name);
	}
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}

class T2 extends Thread{
	T2(String name){
		super(name);
	}
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}