package com.wangrui.adv.coll;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
        // 添加元素 
		q.offer("java");
		q.add("c");
		System.out.println(q.size());
		
		// 查看队列头元素，不取出。
		String i = q.peek(); //q.element(); 空队列会抛出异常。
		System.out.println(i);
		System.out.println("------------------");
		// 取出队列头的元素 。
		System.out.println(q.remove());
		System.out.println(q.poll());
		System.out.println(q.poll()); // 没有元素 ，返回 null.
		System.out.println(q.remove()); // 没有元素，抛出异常。
		
	}
	
}
