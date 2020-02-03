package com.wangrui.adv.file.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BridgeIO {

	public static void write(String fileName, String msg, String charset) throws IOException {
		OutputStreamWriter outWriter = null;
		OutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			outWriter = new OutputStreamWriter(out, charset);
			
			outWriter.append(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(outWriter!= null) {
				outWriter.close();
			}
			if(out!=null) {
				out.close();
			}
		}

	}
	
	public static void read(String fileName, String charset) throws IOException {
		InputStreamReader inReader = null;
		InputStream in = null;
		BufferedReader buffReader = null;
		
		try {
			in = new FileInputStream(fileName);
			inReader = new InputStreamReader(in, charset);
			buffReader = new BufferedReader(inReader);
			String str = null;
			while(null != (str=buffReader.readLine())){
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(buffReader != null) {
				buffReader.close();
			}
			if(inReader != null) {
				inReader.close();
			}
			if(in != null) {
				in.close();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
//		write("/home/wangrui/c", "hello.你好。", "gbk");
		read("/home/wangrui/c","utf-8");
	}
}
