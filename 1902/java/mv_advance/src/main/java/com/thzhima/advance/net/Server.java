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
			server = new ServerSocket(9090);
//			server.bind(new InetSocketAddress(9090));
			// 监听网络请求，阻塞。
			socket = server.accept();
			
			in = socket.getInputStream();
			reader = new InputStreamReader(in);
			bfreader = new BufferedReader(reader);
			out = socket.getOutputStream();
			writer = new OutputStreamWriter(out);
			bfwriter = new BufferedWriter(writer);

			String str = null;
			while(!"".equals(str = bfreader.readLine())){
				System.out.println(str);
			}
			System.out.println("end read-----------");
			//System.out.println(bfreader.readLine());
			System.out.println("end read-----------");

			bfwriter.write("HTTP/1.1 200 OK \n");
			bfwriter.write("Content-type: text/html\n");
			bfwriter.write("Content-length: 5\n");
			bfwriter.write("\n\n");
			bfwriter.write("hello");
			bfwriter.write("\n\n");
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
