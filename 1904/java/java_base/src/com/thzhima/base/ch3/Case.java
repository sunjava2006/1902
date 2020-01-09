package com.thzhima.base.ch3;

public class Case {

	public static void main(String[] args) {
		 int score = (int)(Math.random()*5); //int  String Eum
		 System.out.println(score);
	      
	        switch(score){ 
	            case 5:
	               System.out.println('优');
//	                break;
	            case 4:
	                System.out.println('良');
//	                break;
	            case 3:
	                System.out.println('中');
//	                break;
	            case 2:
	                System.out.println("及格");
	                break;
	            default:
	                System.out.println('差');
	        }
	}
}
