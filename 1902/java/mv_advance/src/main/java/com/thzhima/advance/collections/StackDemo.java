package com.thzhima.advance.collections;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		
		Stack<String> s = new Stack();
		
		s.push("java");
		s.push("python");
		s.push("js");
		s.push("c");
		
		System.out.println(s.peek());
		System.out.println(s.peek());
		System.out.println(s.peek());
		
		s.contains("js");
		
//		while(!s.isEmpty()) {
//			System.out.println(s.pop());
//		}
		
		
	}

}
