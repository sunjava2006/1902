package com.wangrui.mulitithread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		List<Runnable> commands = new ArrayList<>();
		for(int i=0; i<10; i++) {
			Runnable run = new Runnable() {
				public void run() {
					for(int j=0;j<=3;j++) {
						System.out.println(Thread.currentThread().getName());
						try {
							Thread.sleep(2);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			commands.add(run);
			
		}
		
		
		
		// 可缓冲大小的线程池
		ExecutorService cachedPool = Executors.newCachedThreadPool();
		long start = System.currentTimeMillis();
		for(Runnable command : commands) {
		    cachedPool.execute(command);
		}
		cachedPool.shutdown();
		
		while(true) {
			if(cachedPool.isTerminated()) {
				System.out.println(System.currentTimeMillis() - start);
				break;
			}
		}
		
		
		
	}
}
