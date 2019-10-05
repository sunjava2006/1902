package com.thzhima.mvadvance.collections;

import java.util.Collection;

public class MyArrayList<E> {

	private E[]  array ;
	private int size = 0;
	
	
	public MyArrayList(int initCapacity) {
		this.array = (E[]) new Object[initCapacity];
	}
	
	public MyArrayList() {
		this(10);
	}
	
	public int size() {
		return this.size;
	}
	
	public void add(E e) {
		if(size==array.length) {
			Object[] o = new Object[this.array.length+10];
			System.arraycopy(this.array, 0, o, 0, this.array.length);
			this.array=(E[]) o;
		}
		array[size] = e;
		size++;
	}
	
	// 实现
	public void addAll(Collection c) {
		
	}
	
	
	// 实现
	public void remove(int index) {
		size--;
	}
	
	// 实现
	public void removeAll(Collection c) {
		
	}
	
	// 实现
	public boolean isEmpty() {
		
	}
	
	// 实现
	public boolean contains(E e) {
		
	}
	
	public E get(int index) {
		E e = null;
		e = this.array[index];
		return e;
	}
	
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>(2);
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		System.out.println(list.size());
		int max = list.size()-1;
		for(int i=0;i<=max; i++) {
			System.out.println(list.get(i));
		}
	}
}
