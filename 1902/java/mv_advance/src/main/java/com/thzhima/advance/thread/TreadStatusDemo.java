package com.thzhima.advance.thread;

import java.io.IOException;

public class TreadStatusDemo {

	public static void main(String[] args) {
		
		Thread todo = new Thread() {
			public void run() {
				System.out.println("enter:");
				try {
					System.in.read();
					System.out.println("end red.");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
//			    for(int i=0;i<5;i++) {
//			    	System.out.println("---");
//			    	try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//			    }
			}
		};
		
		
		Thread daemon = new Thread() {
			public void run() {
				while(true) {
					try {
						System.out.println(todo.getState());
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
	    daemon.setDaemon(true);
	    daemon.start();
	    
	    
	    todo.start();
	    
	    
	
		
	}
}
