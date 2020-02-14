package com.wangrui.mulitithread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTimerTaskDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() {
				return 99;
				
			}
		};
		
		ScheduledFuture<Integer> f =  pool.schedule(callable, 3 , TimeUnit.SECONDS);
		int value = f.get();
		System.out.println(value);
		
		//=========================================================
		Runnable run  = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hi");
				try {
					Thread.sleep(4000);
					System.out.println("-------------");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		pool.scheduleAtFixedRate(run, 3, 3, TimeUnit.SECONDS);
		
		
//		pool.shutdown();
		
	}
}
