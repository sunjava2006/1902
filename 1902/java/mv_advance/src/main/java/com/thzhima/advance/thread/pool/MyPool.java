package com.thzhima.advance.thread.pool;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyPool<V> {

	private Stack<Thread> stack = new Stack<Thread>();
	private Stack<Runnable> tasks = new Stack<Runnable>();
	private Object[] clocks = null;
	
	public MyPool(int capacity) {
		clocks = new Object[capacity];

		for(int i=0; i<capacity; i++) {
			Object o = new Object();
			clocks[i]=o;
			Thread t = new Thread() {
				@Override
				public void run() {
					try {
						while(true) {
							synchronized (o) {
								tasks.pop().run();								
								stack.push(this);
								o.wait();
							}
							
						}
					} catch (Exception e) {
						
					}
				}
			};
			stack.push(t);
		}
	}
	
	public void execute(Runnable r) {
		if(!this.stack.isEmpty()) {
			this.stack.pop()
		}
	}
	
	
}
