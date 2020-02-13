package com.wangrui.mulitithread.sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSynchro {
	static List<Integer> list = Collections.synchronizedList(new ArrayList<>());//new Vector<>();
	
	
	public static void main(String[] args) throws InterruptedException {
		Runnable target = new MyRunnable();
		Thread t = new Thread(target);
		Thread t2 = new Thread(target);
		t.start();
		t2.start();
		
		// 等待t、t2完成。
		t.join();  // 当前主线程等待t 线程完成，再运行。
		t2.join(); // 当前主线程等待t2 线程完成，再运行
		
		// 查看 list的长度
		System.out.println(list.size());
	
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		for(int i=1;i<=100000;i++) {
			//add(i);
			ListSynchro.list.add(i);
		}
	}
	
	  synchronized void add(int i) {
		ListSynchro.list.add(i);
	}
};