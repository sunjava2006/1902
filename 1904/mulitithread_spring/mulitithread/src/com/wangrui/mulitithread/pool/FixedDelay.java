package com.wangrui.mulitithread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedDelay {

	public static void main(String[] args) {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		pool.scheduleWithFixedDelay(()->{System.out.println("hi"); try {
		                             Thread.sleep(3000);
		                             System.out.println("---------");}catch(Exception ex) {}},
				                     3, 
				                     3, 
				                     TimeUnit.SECONDS);
		
		
	}
}
