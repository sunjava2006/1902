package com.wangrui.adv.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliednt {

	public static void main(String[] args) throws IOException {
		Socket s = null;
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter buffWriter = null;
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader buffReader = null;
		try {
			// 连接服务端。
//			s = new Socket("localhost", 1025, 
//					         InetAddress.getByName("localhost"),9999);
			s = new Socket();
			s.connect(new InetSocketAddress("localhost", 1025));
			
			// 获取输出流 3件套。
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out);
			buffWriter = new BufferedWriter(outWriter);
			
//			outWriter.write("你好。我想要一瓶水。");
//			outWriter.flush();
			buffWriter.append("你好。我想要一瓶水。");
			buffWriter.newLine();
			buffWriter.flush();
			
			// 获取输入流3件套
			in = s.getInputStream();
			inReader = new InputStreamReader(in);
			buffReader = new BufferedReader(inReader);
			String msg = null;
			msg=buffReader.readLine();
			System.out.println(msg);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			buffReader.close();
			inReader.close();
			in.close();
			buffWriter.close();
			outWriter.close();
			out.close();
			s.close();
		}
	}
}
