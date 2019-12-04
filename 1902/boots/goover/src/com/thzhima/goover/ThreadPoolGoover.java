package com.thzhima.goover;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolGoover {

	/**
	 * new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>())
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 单线程池 new ThreadPoolExecutor
		Executors.newSingleThreadExecutor();
		
		// 固定大小线程池 new ThreadPoolExecutor
		Executors.newFixedThreadPool(3);
		
		// 缓冲线程池  new ThreadPoolExecutor
		Executors.newCachedThreadPool();
		
		// 定时任务（延时任务）线程池  ThreadPoolExecutor
		Executors.newScheduledThreadPool(1);
		
	}
}
