package com.thzhima.usually;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateDemo {
	public static void main(String[] args) {
		
		Date now = new Date();
//		System.out.println(now);
//		Date d = new Date(00, 0, 1);
//		System.out.println(d.getDate());
//		
//		int year = d.getYear();
//		System.out.println("========================");
//		Calendar c = Calendar.getInstance();
//		c.set(1995, 3, 3, 3, 3, 3);
//		c.set(Calendar.MONTH, 5);
//		System.out.println(c.get(Calendar.YEAR));
//		System.out.println(c.get(Calendar.MONTH));
//		
//		Date d2 = c.getTime();
//		
//		c.setTimeInMillis(d.getTime());
		
		TimeZone tz = TimeZone.getTimeZone("CN");
		Calendar c = Calendar.getInstance(tz);
		long l = c.getTimeInMillis();
		long ll = now.getTime();
		System.out.println(c.get(Calendar.HOUR));
		
		
		

		
	}
}
