package com.thzhima.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockedTest {

	static ReentrantLock lock = new ReentrantLock();

	public static void to() {

		// lock.lock(); // 锁定
		synchronized (lock) {

			System.out.println(Thread.currentThread().getName() + "--------------------------");
			// lock.lock(); // 锁定
			synchronized (lock) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// lock.unlock(); // 解锁
			}
			System.out.println(Thread.currentThread().getName() + "==============");
			// lock.unlock(); // 解锁
		}
	}

	public static void main(String[] args) {
		Thread t = new Thread(() -> LockedTest.to());
		Thread t2 = new Thread(() -> LockedTest.to());
		t.start();
		t2.start();

	}
}
