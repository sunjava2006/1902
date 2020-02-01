package com.wangrui.adv.coll;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		SortedSet<Number> sort = new TreeSet<>();
		
		sort.add(new Integer(100));
		sort.add(50);
		sort.add(90);
		sort.add(2);
		
		System.out.println(sort);
		
		SortedSet<String> set = new TreeSet<>();
		set.add("china");
		set.add("english");
		set.add("australia");
		System.out.println(set);
		
		// 指定强制比较器。构造时指定。
		SortedSet<People> sset = new TreeSet<>(new PeopleAgeCompartor());
		sset.add(new People("wang",20,"123"));
		sset.add(new People("li",22,"456"));
		sset.add(new People("huang",16,"6123"));
		
		Iterator<People> iter = sset.iterator();
		while(iter.hasNext()) {
			People p = iter.next();
			System.out.println(p);
		}
		
		
		
	}

}
