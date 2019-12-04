package com.thzhima.lambda.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Demo1 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		list.add("java");
		list.add("oracle");
		list.add("python");
		list.add("mysql");
		
//		for(String s : list) {
//			System.out.println(s);
//		}
		
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		System.out.println("---------------------------");
		list.forEach((s)->{System.out.println(s);});
	}
}
