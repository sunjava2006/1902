package com.thzhima.advance.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
private Map<String, Account> map = new HashMap<>();
	
    public synchronized Account getAccount(String account) {
    	Account a = null;
    	a = map.get(account);
    	if(null == a) {
    		// 到数据库取出账号信息，创建账号对象。
    		a = new Account(account, 1000);
    		map.put(account, a);
    	}
    	return a;
    }
    
	public  int pay(Account a, int money) {

		synchronized(a) {
			if(a.amount>=money) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				a.amount-=money;
				return money;
			}
			
		}
		return 0;
	
	}
	
	public  int getAmount(Account a) {
		synchronized(a) {
			int aa =  a.amount;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return aa;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
	
		Account a = bank.getAccount("123");
		Account a2 = bank.getAccount("123");
		
		Thread t = new Thread() {
			public void run() {
				int money = bank.pay(a, 90);
				System.out.println(Thread.currentThread().getName()+":"+money);
			}
		};
		
		Thread t2= new Thread() {
			public void run() {
				int amount = bank.getAmount(a2);
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
