package com.thzhima.base.types.flow;

public class SwitchDemo {

	public static void main(String[] args) {
		switch("1") {
		case "2":
		    System.out.println("1==2");	
		    break;
		case "1":
			System.out.println("1==1");
		    break;
			
		}
		
		Gender g = Gender.FEMALE;
		switch(g) {
		case MALE:
			System.out.println("男人");
		case FEMALE:
			System.out.println("女人");
		}
	}
}
