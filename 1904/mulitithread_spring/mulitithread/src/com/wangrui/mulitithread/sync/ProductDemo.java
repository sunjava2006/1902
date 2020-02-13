package com.wangrui.mulitithread.sync;

import java.util.ArrayList;
import java.util.List;

public class ProductDemo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		Thread producer = new Thread() {
			int count = 1;

			public void run() {
				try {
					while (true) {
						synchronized (list) {
							for (int i = 0; i < 10; i++) {
								System.out.println("--------生產商品ID :" + count);
								list.add(count++);
								Thread.sleep(500);
							}
							list.notifyAll();// 通知阻塞线程竞争
							list.wait(); // 自己进行休眠，释放锁。
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		Thread consumer = new Thread() {
			public void run() {

				try {
					while (true) {
						synchronized (list) {
							while (list.size() > 0) {
								Integer id = list.get(0);
								list.remove(0);
								System.out.println("++++++++++消費商品" + id);
								Thread.sleep(500);
							}
							list.notifyAll();
							list.wait();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		
		producer.start();
		consumer.start();

	}
}
