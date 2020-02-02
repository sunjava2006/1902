package com.wangrui.adv.coll;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CurrentMapDemo {

	public static void main(String[] args) {
		
		ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
		
		map.put(1, "java");
		map.put(2, "c");
		map.put(3, null);// 
		
		System.out.println(map);
		
	}

}
