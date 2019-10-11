package com.thzhima.advance.thread.pool;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {
		Timer t = null;
		t  = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("ooooooooooooooooo");
			}
		};
		t.schedule(task, 2000);
		
//		t.cancel();
	}
}
