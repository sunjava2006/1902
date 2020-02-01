package com.wangrui.adv.coll;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		// Set中存储无序（无存放的先后顺序），不重复（equals()\hashCode()返回值相同）的数据。
		Set<String> set = new HashSet<>();
		set.add("java");
		set.add("c");
		set.add("c");
		set.add("c");
		set.add("c++");
		System.out.println(set.size());
		System.out.println(set);
		
		for(String s: set) {
			System.out.println(s);
		}
		
		System.out.println("c".equals("c") && "c".hashCode()=="c".hashCode());
	}
}
