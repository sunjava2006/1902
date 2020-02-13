package com.wangrui.mulitithread.sync;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public class SynccollDemo {

	public static void main(String[] args) throws InterruptedException {
		Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
		
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					set.add(i);
					System.out.println("------------------");
				}
			}
		};
		
		Runnable runner2 = new Runnable() {
			@Override
			public void run() {
				for(int i=1000;i<2000;i++) {
					set.add(i);
					System.out.println("===============");
				}
			}
		};
		
		
		
		Thread t = new Thread(runner);
		Thread t2 = new Thread(runner2);
		
		
		
		
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(set.size());
		
		
	}
}
