package com.thzhima.usually;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {

	public static void main(String[] args) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		
		Date now = new Date();
		
		String str = fmt.format(now);
		
		System.out.println(str);
		try {
			
			Date d = fmt.parse("2019-09-23 15:03:28");
			System.out.println(d);
		} catch (Exception e) {
			System.out.println("---error:--------"+e.getMessage());
		}
		//============================================================
		
		DateFormat f = DateFormat.getDateInstance();
		
		System.out.println(f.format(now));
		
		f = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println(f.format(now));
		
		System.out.println(DateFormat.getDateTimeInstance().format(now));
		
		System.out.println(DateFormat.getDateTimeInstance(DateFormat.FULL, 
				     0).format(now));
	}
}
