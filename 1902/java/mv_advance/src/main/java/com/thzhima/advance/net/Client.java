package com.thzhima.advance.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket client = null;
		OutputStream out = null;
		OutputStreamWriter writer = null;
		BufferedWriter bf = null;
		InputStream in = null;
		InputStreamReader reader = null;
		BufferedReader bfreader = null;
		try {
			client = new Socket("localhost", 9090);
			in = client.getInputStream();
			
			reader = new InputStreamReader(in);
			bfreader = new BufferedReader(reader);
			out = client.getOutputStream();
			writer = new OutputStreamWriter(out);
			bf = new BufferedWriter(writer);
			
			bf.write("hi\n");
			bf.flush();
			
			
			String msg = bfreader.readLine();
			System.out.println("返回：" + msg);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			bfreader.close();
			reader.close();
			in.close();
			
			bf.close();
			writer.close();
			out.close();
			
			client.close();
		}
	
		
		
	}
}
