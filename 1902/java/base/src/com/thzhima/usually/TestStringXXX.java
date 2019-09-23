package com.thzhima.usually;

public class TestStringXXX {

	public static void main(String[] args) {
		int count = 100000;
		
		String s = "";
		StringBuffer sb = new StringBuffer();
		
		long start = System.currentTimeMillis();
//		for(int i=0;i<count;i++) {
//			s+=i;
//		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println("----------------------------");
		
		start = System.currentTimeMillis();
		for(int i=0;i<count;i++) {
			sb.append(i);
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
			
		
//		System.out.println(s.contentEquals(sb));
	}
}
