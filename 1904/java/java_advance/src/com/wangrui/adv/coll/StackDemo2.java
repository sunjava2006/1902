package com.wangrui.adv.coll;

import java.util.Stack;

public class StackDemo2 {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("c");
		s.push("c++");
		s.push("c--");
		
		System.out.println(s.size());
		String i = s.peek(); // 查看棧顶元素
		System.out.println(i);
		System.out.println(s.size());
		
		// 弹棧
		String ii = s.pop();
		System.out.println(ii);
		System.out.println(s.size());
		System.out.println("-----------------");
		while(!s.empty()) {
			String e = s.pop();
			System.out.println(e);
			
		}
		
		
	}
}
