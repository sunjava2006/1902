package com.wangrui.adv.coll;

import java.util.HashSet;
import java.util.Set;

public class SetPeopleDemo {

	public static void main(String[] args) {
		Set<People> set = new HashSet<>();
		
		People p1 = new People("Zhang", 22, "320111199501013230");
		People p2 = new People("Zhang", 22, "320111199501013230");
		People p3 = new People("Zhang", 22, "320111199501013230");
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(null);
		set.add(null);
		
		System.out.println(set.size());
		System.out.println(set);
		
	}
}
