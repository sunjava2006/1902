package com.thzhima.advance.bank;

public class Bank {
    
	public synchronized int pay(Account a, int money) {
		if(a.amount>=money) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a.amount-=money;
			return money;
		}
		else {
			return 0;
		}
	}
	
	public synchronized int getAmount(Account a) {
		return a.amount;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
	
		Account a = new Account("123", 10000);
		
		Thread t = new Thread() {
			public void run() {
				int money = bank.pay(a, 9000);
				System.out.println(Thread.currentThread().getName()+":"+money);
			}
		};
		
		Thread t2= new Thread() {
			public void run() {
				int amount = bank.getAmount(a);
				System.out.println("-----------------------"+amount);
//				int money = bank.pay(a, 9000);
//				System.out.println(Thread.currentThread().getName()+":"+money);
			}
		};
		
		Thread daemon = new Thread() {
			public void run() {
				while(true) {
					System.out.println(t.getName()+":"+t.getState());
					System.out.println(t2.getName()+":"+t2.getState());
					
				}
			}
			
		};
		daemon.setDaemon(true);
		daemon.start();
		
		
		t.start();
		t2.start();
		
		t.join(); // 当前主线程，在t\t2完成之后才执行.
		t2.join();
		
		System.out.println("余额"+a.amount);
	}
}
