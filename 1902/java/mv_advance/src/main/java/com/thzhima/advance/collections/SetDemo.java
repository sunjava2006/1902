package com.thzhima.advance.collections;

import java.util.HashSet;
import java.util.Set;

import com.thzhima.advance.entity.User;

public class SetDemo {

	public static void main(String[] args) {
//		Set<String> set = new HashSet<>();
//		
//		set.add("c++");
//		set.add("java");
//		set.add("js");
//		set.add("java");
//		System.out.println(set.size());
//		
//	    for(String s: set) {
//	    	System.out.println(s);
//	    }
		
		Set<User> userSet = new HashSet<>();
		User u1 = new User(10, "wang", "123");
		User u2 = new User(10, "wang", "123");
		User u3 = new User(10, "wang", "123");
		
		userSet.add(u1);
		userSet.add(u2);
		userSet.add(u3);
		
		System.out.println(userSet.size());
		
	}
}
