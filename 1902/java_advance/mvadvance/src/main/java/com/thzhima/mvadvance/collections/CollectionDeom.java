package com.thzhima.mvadvance.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDeom {

	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<>();
		c.add(10);
		c.add(20);
		c.add(50);
		c.add(60);
		
		System.out.println("contain 60" + (c.contains(160))); // 集合中是否包含某个元素
		
		Collection<Integer> c2 = new ArrayList<>();
		c2.add(20);
		c2.add(30);
		
		
		c.addAll(c2);  // 添加另一个集合中的数据到当前集合中。包含重复的。
		System.out.println("c 中包含C2? " + (c.containsAll(c2)));
		
		Iterator<Integer> ite = c.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		System.out.println("--------------------------");
		c.remove(10); // 删除一个元素
		ite = c.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
//		c.removeAll(c2); // 删除C2中的元素
		c.retainAll(c2); // 剩下C2中的元素
		System.out.println("--------------------------");
		ite = c.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		
		c.clear(); // 清空集合
		
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		
		// 并 addAll（c2） add(e)
		
		// 交 remainAll(c2) 
		
		// 差 removeAll(c2)  remove(e)
		
		// 包含 containAll(c2)  contain(e)
		
		// 取元素  ： -》迭代器  、 数组
		
		Collection<String> c3 = new ArrayList<>();
		c3.add("china");
		c3.add("english");
		
		Object[] a1 =  c3.toArray();
////		String s = "xx";
////		Object o = s;
//		String[] bb = new String[] {"a","b","c"};
//		Object[] aa = bb;
////		System.out.println(aa);
//		bb  = (String[]) aa;
//		
//	    String[] ss = (String[]) a1;
		
	    for(Object o: a1) {
	    	String s = (String) o;
	    	System.out.println(s);
	    }
		
	       
	    	    
	    String[] strArray = c3.toArray(new String[c3.size()]);
	    for(String s : strArray) {
	    	System.out.println(s);
	    }
	}
}
