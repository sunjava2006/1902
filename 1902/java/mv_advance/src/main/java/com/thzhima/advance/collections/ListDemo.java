package com.thzhima.advance.collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(20);  // 尾部添加
		list.add(1, 30); // 插入
		list.set(1, 40); // 覆盖
		System.out.println(list);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		// for each 语句，用在数组和Iteable接口上。
		for(int i : list) {
			System.out.println(i);
		}
		
		System.out.println("------------------------------------------");
		
		list.remove(1);
		System.out.println(list.size());
		
		for(int i : list) {
			System.out.println(i);
		}
	}
}
