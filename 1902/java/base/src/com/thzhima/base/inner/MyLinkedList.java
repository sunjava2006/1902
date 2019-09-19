package com.thzhima.base.inner;

public class MyLinkedList {
	
	int aa = 90;
	Node node = new Node();
	int bb = Node.b;
	
	static class Node{
        int a = 90;
		static int b = 90;
	}
	
	void a(){
		int a = 90;
		class C{
			int aa = a;
			int cc = MyLinkedList.this.aa;
		}
		
		C c = new C();
	}
	
//	C cc = new C();
	
	public static void main(String[] args) {
//		MyLinkedList li = new MyLinkedList();
//		MyLinkedList.Node node = li.new Node();
//		System.out.println(node instanceof MyLinkedList.Node);
		
		MyLinkedList.Node node  = new MyLinkedList.Node();
	}

}

