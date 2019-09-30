package com.thzhima.advance.io;

import java.io.IOException;
import java.io.InputStreamReader;

public class BridgeStream {

	public static void main(String[] args) throws IOException {
		InputStreamReader inReader = null;
		StringBuffer sb = new StringBuffer();
		try {
		    inReader = new InputStreamReader(System.in, "utf-8");
			char[] buffer = new char[4];
			while(true) {
				int count = inReader.read(buffer);
				sb.append(buffer,0,count);
				if(buffer[count-1]=='\n') {
					break;
				}
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != inReader) {
				inReader.close();
			}
		}
		
		
	}
}
