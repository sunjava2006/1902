package com.thzhima.advance.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpDemo {

	public static void main(String[] args) throws IOException {
		InputStream in = null;
		InputStreamReader reader = null;
		BufferedReader bfreader = null;
	    try {
			URL url = new URL("http://www.sina.com.cn");//new URL("file:///home/wangrui/hello.py");
			System.out.println(url.getContent());
		     in = url.openStream();
		     reader = new InputStreamReader(in);
		     bfreader = new BufferedReader(reader);
		     
		    String msg  = null;
		    while(null != (msg = bfreader.readLine())) {
		    	System.out.println(msg);
		    }
		     
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		}	finally {
			bfreader.close();
			reader.close();
			in.close();
		}
	}
}
