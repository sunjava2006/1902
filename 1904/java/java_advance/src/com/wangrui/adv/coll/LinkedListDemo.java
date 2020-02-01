package com.wangrui.adv.coll;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		
		list.add("java");
		list.add("python");
		list.add(1,"c"); // "java\c\python"
		System.out.println(list);
		
		list.addFirst("js");
		System.out.println(list);
		
		
	}
}
