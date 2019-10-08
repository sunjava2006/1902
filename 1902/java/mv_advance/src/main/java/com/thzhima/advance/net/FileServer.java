package com.thzhima.advance.net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket s = null;
		InputStream in = null;
		byte[] buffer = new byte[1024];
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("/home/wangrui/aa.jpeg");
			server = new ServerSocket(9090);
			s = server.accept();
			
			in = s.getInputStream();
			int count = 0;
			while( -1 != (count=in.read(buffer))) {
				fout.write(buffer, 0, count);
			}
			fout.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fout.close();
			in.close();
			s.close();
			server.close();
		}
	}
}
