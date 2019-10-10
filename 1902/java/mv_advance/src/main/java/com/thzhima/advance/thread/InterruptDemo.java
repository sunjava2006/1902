package com.thzhima.advance.thread;

public class InterruptDemo {
   
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			
			public void run() {
				while(true) {
					System.out.println("------------------");
					if(Thread.interrupted()) { // 会清除中断标记，
						System.out.println(Thread.interrupted());
						break;
					}
//					if(this.isInterrupted()) { // 不会清除中断标记
//						System.out.println(this.isInterrupted());
//						break;
//					}
				}
			}
		};
		
		t.start();
		
		
		Thread.sleep(10000);
		t.interrupt();
		
	}
	
	
}
