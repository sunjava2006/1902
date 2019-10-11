package com.thzhima.advance.thread.valatile;

public class Staue {
	volatile boolean loop = true;
	
	public void a() {
		try {
			Thread.sleep(1300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loop  = false;
		System.out.println("----------------------------------------"+this.loop);
	}
	
	public void b(Staue s) {
		while(s.loop) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
	  Staue s = new Staue();
	  
	  Thread t = new Thread() {
		public void run() {
			s.b(s);
		}
	  };
	  t.start();
	  
	  Thread t2 = new Thread() {
			public void run() {
				s.a();
			}
		  };
		  t2.start();
	  
	  
		
	}
}
