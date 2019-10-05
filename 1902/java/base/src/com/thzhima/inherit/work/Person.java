package com.thzhima.inherit.work;

public class Person {
   public String name;
   public final String GENDER;
   public String birthday;
    
   public Person(String gender) {
	   this.GENDER = gender;
   }
   
   public void work() {
	   System.out.println("劳动中.");
	   
   }

}
