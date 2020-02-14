package com.wangrui.mulitithread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedSizeThreadPool {

	public static void main(String[] args) {
		ExecutorService pool =  Executors.newFixedThreadPool(2);
		
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
		
		long start = System.currentTimeMillis();
		for(Runnable command : commands) {
		    pool.execute(command);
		}
		
        pool.shutdown();
		
		while(true) {
			if(pool.isTerminated()) {
				System.out.println(System.currentTimeMillis() - start);
				break;
			}
		}
		
	}
}
