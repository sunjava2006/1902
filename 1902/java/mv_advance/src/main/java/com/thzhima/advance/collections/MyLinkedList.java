package com.thzhima.advance.collections;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E>{

	private int size;
    private Node first; //头节点指针 
    private Node last; //尾节点指针
	
	public int size() {
		return this.size;
	}
	
	public void add(E e) {
		Node newNode = new Node(e, null, null);
		 if(size == 0) {
			 this.first = newNode;
			 this.last = newNode;
		 } else {
			 newNode.previous = last; // 新节点的前向指针，指向链中最后一个节点。
			 this.last.next = newNode; // 链中最后一个节点的后向指针，指向新节点。
			 this.last = newNode; // 将last指针，指向新节点。（移动last指针的指向）
		 }

		 size++;
	}
	
	public E get(int index) {
		if(index < 0  ||  index >=size) {
			return null;
		}else {
			if(index == size-1) {
				return this.last.data;
			}
			else {
				Node curr = this.first;
				for(int i=0;i<index;i++) {
					curr = curr.next;
				}
				return curr.data;
			}
		}
		
	}
	
	public boolean remove(int index) {
		if(index>=0 && index<size) {
			if(0 == index) {
				this.first = this.first.next; // 移动first指针，第二个节点，当成头节点。
				this.first.previous.next = null; //  原前一个节点的后向指针为null。
				this.first.previous = null; // 当前头节点的前向指针为null,原头节点自由。
			}else if(size-1 == index) {
				this.last = this.last.previous; // 将倒数第二个节点，当成尾节点。
				this.last.next.previous = null;  // 最后一个节点，不再指向前一个节点。
				this.last.next = null; // 当前最后一个节点，不再指向下一个节点。
			}else {
				Node curr = this.first;
				for(int i=0;i<index;i++) {
					curr = curr.next;
				}
				curr.previous.next = curr.next; //将“我”前一个节点指向“我”后的节点。
				curr.next.previous = curr.previous; // 将"我"后的节点指向“我”前的节点。
				curr.previous = null; // “我” 节点自由 
				curr.next = null; 
			}
			size--;
			return true;
		} 
		return false;
	}
    
	public boolean isEmpty() {
		if(0==size) {
			return true;
		}else {
			return false;
		}
	}
	
	public void clear() {
		size=0;
		this.first = this.last = null;
	}
	
	//===========================
	private class Node{
		private E data; // 数据
		private Node previous; // 前向指针 
		private Node next; //后向指针
		
		Node(){
		}
		
		Node(E data, Node previous, Node next){
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
		
		
	}
	
	@Override
	public Iterator<E> iterator() {
		
		return new Iterator<E>() {
            private int start = 0;
			@Override
			public boolean hasNext() {
				if(this.start<size) {
					return true;
				}
				return false;
			}

			@Override
			public E next() {
				E e =  get(start);
				this.start++;
				return e;
			}
			
		};
	}
	//===================================
	
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		
		list.add("china");
		list.add("english");
		list.add("japanese");
		list.add("spanish");
		
//		for(int i=0; i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
		
		for(String s : list) {
			System.out.println(s);
		}
	}

	
	
}
