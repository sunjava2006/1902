package com.thzhima.advance.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		Socket socket = null; // 网络连接（套接字）
		InputStream in = null;
		InputStreamReader reader = null;
		BufferedReader bfreader = null;
		OutputStream out = null;
		OutputStreamWriter writer = null;
		BufferedWriter bfwriter = null;
		
		try {
			server = new ServerSocket();
			server.bind(new InetSocketAddress(9090));
			
			//监听网络请求，阻塞。
			socket = server.accept();
			in = socket.getInputStream();
			reader = new InputStreamReader(in);
			bfreader = new BufferedReader(reader);
			out = socket.getOutputStream();
			writer = new OutputStreamWriter(out);
			bfwriter = new BufferedWriter(writer);
			
			String str = null;
			   str  = bfreader.readLine();
				System.out.println("收到："+str);
		
			
	
			bfwriter.write("hello\n");
			bfwriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bfreader.close();
			reader.close();
			in.close();
			
			bfwriter.close();
			writer.close();
			out.close();
			
			socket.close();
			server.close();
		}
	
	}
}
