package com.thzhima.advance.net;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class FileClient {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = null;
		OutputStream out = null;
		byte[] buffer  = new byte[1024];
		Socket s = null;
		
		try {
			s = new Socket("localhost", 9090);
			out = s.getOutputStream();
			fin = new FileInputStream("/home/wangrui/下载/girl.jpeg");
			int  count =0;
			while(-1 != (count=fin.read(buffer))) {
				out.write(buffer,0, count);
			}
			out.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fin.close();
			out.close();
			s.close();
		}
		
		
	}
}
