package com.wangrui.adv.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {

	public static void main(String[] args) throws IOException {
		Socket s = null;
		ServerSocket ss = null;
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader buffReader = null;
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter buffWriter = null;
		try {
			// 用来进行服务请求监听的对象。1025端口上监听。
			ss = new ServerSocket(1025);
			// 一直监听到有用户请求，才返回。返回的Socket对象，表示一个连接。
			s = ss.accept(); 
			SocketAddress remoteAddress = s.getRemoteSocketAddress();
			System.out.println(remoteAddress);
		
			// 获取输入流3件套
			in = s.getInputStream();
			inReader = new InputStreamReader(in);
			buffReader = new BufferedReader(inReader);
			String msg = null;
	
			msg=buffReader.readLine();
			System.out.println(msg);
	
			System.out.println("----------------");
			// 回复消息，输出流。
			// 获取输出流 3件套。
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out);
			buffWriter = new BufferedWriter(outWriter);
			buffWriter.write("没有水了!\n");
			buffWriter.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			buffWriter.close();
			outWriter.close();
			out.close();
			buffReader.close();
			inReader.close();
			in.close();
			s.close();
			ss.close();
		}
	}
}
