package com.thzhima.usually;

public class WraperDemo {
	public static void main(String[] args) {
		
//		Integer i = new Integer(10); 
//		int ii = i.intValue();
		
		Integer i = 10;
		i = 20;
		Integer ii = 10;
		Integer iii  =  new Integer(10);
		Integer iiii  =  new Integer(10);
		
		System.out.println(i == ii);
		System.out.println(iiii == iii);

	}
	
}
