package com.thzhima.advance.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import oracle.net.aso.s;

public class Server2 {

	public static void main(String[] args) throws IOException {
		Process p = null;
		ServerSocket server = null;
		Socket s = null;
		try {
			server = new ServerSocket(9090);
			s = server.accept();
			p = new Process(s);
			
			String msg = p.getMsg();
			System.out.println(msg);
			
			p.writeMsg("-----------------------------------");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			p.release();
			s.close();
			server.close();
		}
	}
}
