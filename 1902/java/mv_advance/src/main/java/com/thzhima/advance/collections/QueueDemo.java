package com.thzhima.advance.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<Integer> q = new ArrayDeque();
		
//		q.add(10);
//		q.offer(20);
		q.offer(null);
		q.add(null);
		
		System.out.println(q.peek());
		System.out.println(q.element());
		
		System.out.println(q.size());
		
		System.out.println(q.poll());
		System.out.println(q.remove());
		
		System.out.println(q.isEmpty());
		System.out.println(q.poll());
		System.out.println(q.remove());
		
	}
}
