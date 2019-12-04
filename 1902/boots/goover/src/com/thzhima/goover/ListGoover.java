package com.thzhima.goover;

import java.util.ArrayList;
import java.util.List;

public class ListGoover {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(null);
		list.add(400);
		
		System.out.println(list.size());
		list.remove(3);
		System.out.println(list.size());
		
		list.forEach((i)->System.out.println(i));
		
	}
}
