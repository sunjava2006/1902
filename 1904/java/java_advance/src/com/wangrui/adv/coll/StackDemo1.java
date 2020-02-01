package com.wangrui.adv.coll;

import java.util.Stack;

public class StackDemo1 {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.add("c");
		s.add("c++");
		s.add("c--");
		
		System.out.println(s.get(0));
		System.out.println(s.search("c")); // 栈方法：3
		System.out.println(s.indexOf("c")); //  列表方法： 0
		
		for(String i: s) {
			System.out.println(i);
		}
	
		
	}
}
