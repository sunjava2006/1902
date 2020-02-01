package com.thzhima.base.ch11;

public class ComparToDemo {

	public static void main(String[] args) {
		Character c = 'c';
		Character cc = 'a';

	    int compareValue = c.compareTo(cc);
	    
	    int cv = "china".compareTo("english");
	    
	    Byte b = 12;
	    Byte bb = 24;
	    int cv2 = b.compareTo(bb);
	    
	    Boolean bf = true;
	    Boolean ff = false;
	    int cv3 = bf.compareTo(ff);
	    
	    System.out.println("=================");
	    System.out.println("china".compareToIgnoreCase("China"));
	    System.out.println("china".equalsIgnoreCase("cHINA"));
	    
	    
	    
	}
}
