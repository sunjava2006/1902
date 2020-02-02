package com.wangrui.adv.coll;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {
		Comparator<Integer> compartor = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		};
		
		SortedMap<Integer, String> map = new TreeMap<>(compartor);
		map.put(3, "c");
		map.put(1, "java");
		map.put(9, "js");
		map.put(2, "python");
		
		System.out.println(map);
		
		Set<Integer> keys = map.keySet();
		Iterator<Integer> ite = keys.iterator();
		while(ite.hasNext()) {
			Integer key = ite.next();
			String v = map.get(key);
			System.out.println(key + ":" + v);
		}
		
		
	}
}
