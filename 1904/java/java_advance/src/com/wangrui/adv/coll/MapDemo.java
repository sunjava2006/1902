package com.wangrui.adv.coll;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		Map<Integer, String> map = new Hashtable<>();//new HashMap<>();
		
		map.put(1,"CN");
		map.put(2, "USA");
		map.put(3, "UK");
		map.put(3, "JP");
//		map.put(null, "empty");// HashMap中Key可以为null，Hashtable不可以
//		map.put(3, null);
		
		String c1 = map.get(1);
		System.out.println(c1);
		System.out.println(map.get(3));
		System.out.println(map.remove(1,"CN2"));//精准删除（同时指定Key和Value）
		System.out.println(map.get(1));
//		System.out.println(map.get(null));
		
		System.out.println(map.size());

		//------------------------ 遍历MAP中的数据 -------------------------
		System.out.println("==================================");
		Set<Map.Entry<Integer, String>> entrys = map.entrySet();
		System.out.println(entrys.size());
		
		for(Map.Entry<Integer, String> en : entrys) {
			Integer key = en.getKey();
			String value = en.getValue();
			System.out.println(key + ":" + value);
		}
		
		Iterator<Map.Entry<Integer, String>> ite = entrys.iterator();
		while(ite.hasNext()) {
			Map.Entry<Integer, String> en = ite.next();
			Integer key = en.getKey();
			String value = en.getValue();
			System.out.println(key + ":" + value);
		}
		//----------------------------------------------------
		Set<Integer> keys = map.keySet();
		Collection<String> valus = map.values();
		
	}

}
