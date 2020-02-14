package com.wangrui.mulitithread.pool;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("传递日志...");
				timer.cancel();
			}
		};
		
		 Date date = new Date(2020-1900,1,14,11,5);
		// 在指定时间执行，以后每间隔多长时间，执行一次。
		//timer.scheduleAtFixedRate(task, new Date(2020-1900,1,14,10,51), 1000*10);
		
		// 在指定多长时间后执行第一次，以后每间隔多长时间执行一次。
		//timer.scheduleAtFixedRate(task, 1000*10, 1000*10);
		
		timer.schedule(task, date);
		System.out.println("--------------");
		//timer.cancel();
		System.out.println("=================");
		
		
	}
}
