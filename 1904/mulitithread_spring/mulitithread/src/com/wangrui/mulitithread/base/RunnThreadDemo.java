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
//		t.run(); 仅是普通的对象方法的调用。不会启动新的线程。
	}
}



//  课间练习时间，10:40 开始下一节内容
/**练习：
 * 两种方式实现子线程 ： 1 、直接继承Thread类，重写run方法
 *                      2 、实现Runnable接口，传递给Thread类。
 *                      3 、指定线程名
 *                      线程体：获取当前线程，输出线程名。
*/








