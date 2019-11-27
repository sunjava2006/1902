package com.thzhima.goover;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapGoover {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		
		set.iterator().forEachRemaining((i)->System.out.print(i));
		Iterator<Map.Entry<String, Integer>> ite = set.iterator();
		System.out.println("\n--------------------------");
		while(ite.hasNext()) {
			Map.Entry<String, Integer> ety= ite.next();
			String key = ety.getKey();
			int val = ety.getValue();
			
			System.out.format("%s = %d\n", key, val);
		}
		
		System.out.println("====================================");
		
		Set<String> keyset = map.keySet();
		keyset.forEach((k)->{
			int v = map.get(k);
			System.out.println(k + "=" + v);
		});
		
		System.out.println("=======================================");
		
		Collection<Integer> values = map.values();
		
		for(Integer i : values) {
			System.out.println(i);
		}
	}
}
