package com.thzhima.mvadvance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws IOException
    {
//        FileReader reader = null;
//        BufferedReader bufReader = null;
//        StringBuffer sb = new StringBuffer();
//        
//        Collection<String> collection = new ArrayList<>();
//        
//        try {
//			reader = new FileReader("d:\\user_info.txt");
//			bufReader = new BufferedReader(reader);
//			
//			String s = null;
//			
//			while(null != (s=bufReader.readLine())) {// 行读，读出的字符串是没有换行符的。
//				//System.out.print(s+ "\n");
//				sb.append(s).append("\r\n"); // 加换行符
//				collection.add(s+"\r\n");
//			}
//			
//			System.out.println(sb);
//			Iterator ite = collection.iterator();
//			while(ite.hasNext()) {
//				System.out.println(ite.next());
//			}
//			
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			bufReader.close();
//			reader.close();
//		}
    	
    	String str = "刘小红|13912345678\r\n" + 
    			     "Marry|13012345678\r\n" + 
    			     "Jack|13822234334";
    	Collection<String> c = new ArrayList<>();
    	String[]  arrayA = str.split("\r\n");
    	
    	for(String line : arrayA) {
    		String[] arrayB = line.split("\\|");
    		StringBuffer sb = new StringBuffer();
    		sb.append(arrayB[1]).append("|").append(arrayB[0]).append("\r\n");
    		c.add(sb.toString());
    		
    	}
    	
    	Iterator ite = c.iterator();
    	while(ite.hasNext()) {
    		System.out.println(ite.next());
    	}
    	
    	
        
    }
}
