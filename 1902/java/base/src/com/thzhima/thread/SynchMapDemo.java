package com.thzhima.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchMapDemo {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap() {
            private Object o = new Object();
			@Override
			public Object put(Object key, Object value) {
				synchronized (o) {
					return super.put(key, value);
				}
			}
		     
		};
		
		
	}
}
