package com.thzhima.advance.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
			Map<String, Object> map = null; // 映射
			map = new HashMap();
			
			map.put("id", 10);
			map.put("name", "工具");
			
			int id = (int)map.get("id");
		    String name = (String)map.get("name");
		    
		    System.out.println(id + ":" + name);
			
	}
}
