package com.thzhima.mvadvance.collections;

import java.util.ArrayList;
import java.util.Vector;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		Vector<Integer> v = new Vector<>(10, 30);
		
//		System.out.println("初始容量："+v.capacity());
//		System.out.println("大小："+v.size());
//		
//		v.ensureCapacity(30);
//		System.out.println("调整容量："+v.capacity());
//		
		
		// 添加10个数据1-10，
		for(int i=0 ;i<10; i++) {
			v.add(i+1);
		}
		System.out.println(v);
		// 删除偶位的数据。(1,2,3)
		for(int i=v.size()-1; i>0; i-=2) {
			v.remove(i);
		}
		
		System.out.println(v);
		
		// 为剩下的奇位数据+1，添加到这个奇位前面。2，1，4，3，6，5，8，7，10，9
		for(int i=v.size()-1; i>=0; i-=1) {
			int n = v.get(i)+1;
			v.add(i, n);
		}
		System.out.println(v);
		
		
	}
}
