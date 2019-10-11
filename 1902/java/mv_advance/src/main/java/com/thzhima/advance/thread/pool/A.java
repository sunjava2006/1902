package com.thzhima.advance.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class A {
	public static void main(String[] args) {
		// 创建固定大小的线程池
//		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		// 大小可变的线程池。
		ExecutorService pool = Executors.newCachedThreadPool();
		
	
		
		ThreadPoolExecutor p = (ThreadPoolExecutor)pool;
		for(int i=0;i<8;i++) {
			pool.execute(new Runnable() {
										public void run() {
											System.out.println("-----------------------------"+Thread.currentThread().getName());
										}
				               }
			);
			System.out.println(p.getActiveCount());
		}
		pool.shutdownNow();
	
	}
}
