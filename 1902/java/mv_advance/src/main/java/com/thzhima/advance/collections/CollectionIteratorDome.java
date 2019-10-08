package com.thzhima.advance.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionIteratorDome {

	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>(); // List的子类
		c.add("china");
		c.add("english");
		c.add("japan");
		
		
		Iterator<String> ite = c.iterator();  // 获取集合的替代器
		while(ite.hasNext()) { // 判断有没有下一个元素
			String e= ite.next();  // 取出下一个元素
			System.out.println(e);
			//ite.remove(); // 删除当前元素
		}
		
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		System.out.println("---------------------------------------");
		//-----------------------ListIterator 双向迭代器------------------------------------
		List<String> li = (ArrayList)c;
		ListIterator liIte = li.listIterator();
		
		while(liIte.hasNext()) {
			System.out.println(liIte.next());
		}
		while(liIte.hasPrevious()) {
			System.out.println(liIte.previous());
		}
		
	}
}
