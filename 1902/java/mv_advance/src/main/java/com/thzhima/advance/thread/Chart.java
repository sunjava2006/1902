package com.thzhima.advance.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Chart {
	public static void main(String[] args) {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(45678);
			while(true) {
				Socket s = server.accept();
				Runner runner = new Runner(s);
				Thread t = new Thread(runner);
				t.start();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Runner implements Runnable{
    private Socket s;
    Runner(Socket s){
    	this.s = s;
    }
	@Override
	public void run() {
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader reader = null;
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		BufferedWriter writer = null;
		
		try {
			in = s.getInputStream();
			inReader = new InputStreamReader(in);
			reader = new BufferedReader(inReader);
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out);
			writer = new BufferedWriter(outWriter);
			
			String msg = null;
			
			while(true) {
				msg = reader.readLine();
		
				String hostName = s.getInetAddress().getHostName();
				int port = s.getPort();
				System.out.format("收到%s:%d,发送来的消息:%s", hostName, port, msg);
				System.out.println();
				
				writer.write(msg+"\n");
				writer.flush();
				
				if(":bye!".equalsIgnoreCase(msg)) {
					System.out.println("-----------:byte!-----------------");
					break;
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			System.out.println("-----------------处理结束-------------------");
			try {
				if(null != writer) {
					writer.close();
				}
				if(null != outWriter) {
					outWriter.close();
				}
				if(null != out) {
					out.close();
				}
				if(null != reader) {
					reader.close();
				}
				if(null != inReader) {
					inReader.close();
				}
				if(null != in) {
					in.close();
				}
				if(null != s && (!s.isClosed())){
					s.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
	}
	
}