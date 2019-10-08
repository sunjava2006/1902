package com.thzhima.advance.collections;

import java.util.List;
import java.util.Vector;

public class VectorThreadSeafDemo {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> list =  new Vector<>();//new ArrayList<>();
		
		Thread t = new Thread() {
			public void run() {
				for(int i=0;i<200;i++) {
					list.add(i);
				}
				System.out.println("t end");
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for(int i=0;i<200;i++) {
					list.add(i);
				}
				System.out.println("t2 end");
			}
		};
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(list.size());
		
		
	}
}
