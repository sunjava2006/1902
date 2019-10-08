package com.thzhima.advance.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {

	public static void main(String[] args) {
		Map<String, Integer> map = new Hashtable();//new HashMap<>();
		
		map.put("one", 1);
		map.put("tow", 2);
		map.put("one", 100);
//		map.put(null, 0);// Hashtable key不能为null;
//	    map.put(null, 1000000);
	    System.out.println(map.size());
		
		System.out.println(map.get("one"));
		System.out.println(map.get("xxx"));
//		System.out.println(map.get(null));
		
		Set<String> keyset = map.keySet();
		Collection values = map.values();
		System.out.println("--------------------------------");
		System.out.println(keyset); 
		System.out.println(values);
		Set<Map.Entry<String, Integer>>  entrySet = map.entrySet();
		System.out.println(entrySet);
		
	}
}
