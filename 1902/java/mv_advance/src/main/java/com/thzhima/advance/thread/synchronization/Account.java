package com.thzhima.advance.thread.synchronization;


public class Account {

	String account;
	int amount;
	
	Account(String account, int amount){
		this.account = account;
		this.amount = amount;
	}
	
	public  int pay(int money) {
		synchronized(this) {
			if(amount>=money) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				amount-=money;
				return money;
			}
			
		}
		return 0;
	
	}
	
	public synchronized int getAmount() {
		return amount;
	}
	
}
