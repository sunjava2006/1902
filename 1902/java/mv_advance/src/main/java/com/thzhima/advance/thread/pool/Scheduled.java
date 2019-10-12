package com.thzhima.advance.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Scheduled {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		ScheduledThreadPoolExecutor
		Callable<String> command = new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("-----------------");
				return "Wang";
			}
			
		};
		
		Runnable command2 = new Runnable() {

			@Override
			public void run() {
				System.out.println("-----------------");
			}
			
		};
		
		ScheduledFuture<String> f = pool.schedule(command, 2, TimeUnit.SECONDS);
		//pool.scheduleAtFixedRate(command2, 2, 2, TimeUnit.SECONDS);
		
//		Future<String> f  = pool.submit(command);
		String value = f.get();
		System.out.println(value);
		
		pool.shutdown();
	}
}
