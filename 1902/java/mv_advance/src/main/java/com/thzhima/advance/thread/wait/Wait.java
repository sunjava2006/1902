package com.thzhima.advance.thread.wait;

import java.util.ArrayList;
import java.util.List;

public class Wait {
	static int seri = 1;
	public static void main(String[] args) {
		List<Integer> schema = new ArrayList<>();

		Thread p = new Thread() {
			public void run() {
				try {
					while(true) {
						synchronized (schema) {
							for(int i=0;i<10;i++) {
								System.out.println("生产：" + seri);
								schema.add(seri++);
								Thread.sleep(1000);
							}
							schema.notify();
							schema.wait();
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		};
		p.start();
		
		Thread c = new Thread() {
			public void run() {
				try {
					while(true) {
						synchronized (schema) {
						    while(schema.size()>0) {
						    	int goods = schema.get(0);
						    	System.out.println("消费："+goods);
						    	schema.remove(0);
						    	Thread.sleep(1000);
						    }
						    schema.notifyAll();
						    schema.wait();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		c.start();
		
	}
}
