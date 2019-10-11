package com.thzhima.advance.thread.synchronization;

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
    
	public int pay(Account a, int money ) {
		return a.pay(money);
	}
	
	public int getAmount(Account a) {
		return a.getAmount();
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		Account a1  = bank.getAccount("123");
		Account a2  = bank.getAccount("123");
		System.out.println(a1== a2);
		
		Thread t1 = new Thread(new A(a1));
		Thread t2 = new Thread(new B(a1));
		
		Thread daemon = new Thread() {
			public void run() {
				while(true) {
					System.out.println(t1.getName()+":"+t1.getState());
					System.out.println(t2.getName()+":"+t2.getState());
					
				}
			}
			
		};
		daemon.setDaemon(true);
		daemon.start();
		
		
		t1.start();
		t2.start();
		
	}
}

class A implements Runnable{
   Account a;
   A(Account a){
	   this.a = a;
   }
	@Override
	public void run() {
		int m = a.pay(1000);
		System.out.println(m);
	}
	
}

class B implements Runnable{
	   Account a;
	   B(Account a){
		   this.a = a;
	   }
		@Override
		public void run() {
			int m = a.pay(1000);
			System.out.println(m);
		}
		
	}
