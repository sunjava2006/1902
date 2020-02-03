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

public class HttpServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = null;
		Socket s = null;
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader bufferReader = null;
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter buffWriter = null;
		try {
			ss = new ServerSocket(8989);
			s = ss.accept();
			in = s.getInputStream();
			inReader = new InputStreamReader(in);
			bufferReader = new BufferedReader(inReader);
			
			String msg = null;
			while(!"".equals(msg)) {
				msg = bufferReader.readLine();
				System.out.println(msg);
				
			}
			System.out.println("-------------------");
			// 获取输出流 3件套。
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out);
			buffWriter = new BufferedWriter(outWriter);
			
			buffWriter.append("HTTP/1.1 200 OK");
			buffWriter.newLine();
			buffWriter.append("Content-Type:text/html");
			buffWriter.newLine();
			buffWriter.append("Content-Length:5");
			buffWriter.newLine();
			buffWriter.newLine();
			buffWriter.append("hello");
			buffWriter.newLine();
			buffWriter.flush();
			
			System.out.println("end");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// closs 之前，先判断是否不为null
			buffWriter.close();
			outWriter.close();
			out.close();
			bufferReader.close();
			inReader.close();
			in.close();
			s.close();
			ss.close();
		}
		
	}
}
