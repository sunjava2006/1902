package com.thzhima.lambda.demo;

public class Demo2 {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				
			}
		});
		
		
		Thread t2 = new Thread(()->{
			System.out.println("running.............");
		}) ;
		
		t2.start();
	}
}
