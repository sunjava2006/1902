package com.thzhima.base.ch5;

public class FeiBo {

	public static void main(String[] args) {
		int[] array = new int[20];
		
		array[0] = array[1] = 1;
		
		for(int i=0; i<=17; i++) {
			array[i+2] = array[i]+array[i+1];
		}
		
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+ ", ");
		}
	}

}
