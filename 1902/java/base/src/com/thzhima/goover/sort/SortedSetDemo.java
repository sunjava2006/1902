package com.thzhima.goover.sort;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
	
		SortedSet<Integer> set = new TreeSet();
		
		set.add(100);
		set.add(30);
		set.add(50);
		set.add(10);
		set.add(10);
		
		set.forEach((e)->System.out.println(e));
		
		Comparator compartor = new Comparator<Human>() {

			@Override
			public int compare(Human o1, Human o2) {
				// TODO Auto-generated method stub
				return o1.tall-o2.tall;
			}
		};
		
//		SortedSet<Human> set1 = new TreeSet<>(compartor);
		SortedSet<Human> set1 = new TreeSet<>((o1,o2)->o1.tall-o2.tall) ;
		set1.add(new Human(10, 173));
		set1.add(new Human(12,156));
		set1.add(new Human(20, 189));
		
		set1.forEach((e)-> System.out.println(e));
		
		SortedMap<Human, String> map = new TreeMap<>((a,b)->a.tall-b.tall);
		
		Human h = new Human(10, 170);
		Human h2 = new Human(20, 160);
		Human h3 = new Human(30, 150);
		
		map.put(h, "Li");
		map.put(h2, "Zhang");
		map.put(h3, "wang");
	
		map.keySet().forEach((e)->System.out.print(e));
		
	}

}
