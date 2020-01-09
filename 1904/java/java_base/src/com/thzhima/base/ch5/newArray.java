package com.thzhima.base.ch5;

public class newArray {

	public static void main(String[] args) {
		int[] a = {10,30,50,70};
		
		//创建一个数组b,内容与a相同。
		int[] b = new int[a.length];
		for(int i=0;i<a.length;i++) {
			b[i]=a[i];
		}
		for(int i=0;i<b.length;i++) {
			int k = b[i];
			k *= 2;
			System.out.print(k +";");
		}
		
		for(int k : b) {
			System.out.println(k);
		}
			
	}

}
