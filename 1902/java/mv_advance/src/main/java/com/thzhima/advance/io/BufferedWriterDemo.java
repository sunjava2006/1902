package com.thzhima.advance.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BufferedWriterDemo {

	public static void main(String[] args) throws IOException {
		// 输出字符-桥接-字节
		OutputStream out  = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter writer = null;
		
		try {
			out = new FileOutputStream("/home/wangrui/abc.txt");
			outWriter = new OutputStreamWriter(out, "gb2312");
			writer = new BufferedWriter(outWriter);
			
			writer.write("大家好。明天是国庆节。");
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			writer.close();
			outWriter.close();
			out.close();
		}
		
		
	}
}
