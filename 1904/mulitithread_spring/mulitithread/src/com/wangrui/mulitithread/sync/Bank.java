package com.wangrui.mulitithread.sync;

public class Bank {
	
	static class Account{
		String account;
		int remain;
		Account(String account, int remain){
			this.account = account;
			this.remain = remain;
		}
		
	}
	
	// 同步方法（多个线程操作当前对象的同步方法，只有一个线程可以执行。）
	public  void store(Account account ,int amount) throws InterruptedException {
		
			System.out.println(Thread.currentThread().getName()+"开始存钱");
			synchronized(account) {
				int sum = account.remain+amount;
				Thread.sleep(50);// 模拟CPU机时让出。
				account.remain = sum;
			}
			System.out.println(Thread.currentThread().getName()+"结束存钱");
		
	}
	
	public  int get(Account account, int amount) throws InterruptedException {
		System.out.println("-------开始取钱"+ amount);
		int get = 0;
		synchronized(account) {
			if(account.remain>=amount) {
				get = amount;
				int remain = account.remain-get;
				Thread.sleep(5);
				account.remain = remain;
			}
		}
		System.out.println("-------结束取钱"+ get);
		return get;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
		Account account = new Account("123456xyz", 500);
		Account account2 = new Account("123456xyz", 500);
		
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				try {
					bank.store(account, 500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable runnerget = new Runnable() {
			@Override
			public void run() {
				try {
					bank.get(account2, 500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t = new Thread(runner);
		Thread t2 = new Thread(runnerget);
		t.start();
		t2.start();
		t.join();
		t2.join();
		
		System.out.println("余额："+account.remain);
		System.out.println("余额："+account2.remain);
	}
}
