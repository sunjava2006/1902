package com.thzhima.advance.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Process {

	OutputStream out = null;
	OutputStreamWriter writer = null;
	BufferedWriter bfwriter = null;
	InputStream in = null;
	InputStreamReader reader = null;
	BufferedReader bfreader = null;
	private Socket s;
	boolean initIn;
	boolean initOut;
	
	Process(Socket s){
		this.s = s;
	}
	
	private void initIn() throws IOException {
		in = s.getInputStream();
		reader = new InputStreamReader(in);
		bfreader = new BufferedReader(reader);
		
	}
	
	private void initOut() throws IOException {
		out = s.getOutputStream();
		writer = new OutputStreamWriter(out);
		bfwriter = new BufferedWriter(writer);
	}
	
	private void closeIn() throws IOException {
		bfreader.close();
		reader.close();
		in.close();
	}
	
	private void closeOut() throws IOException {
		bfwriter.close();
		writer.close();
		out.close();
	}
	
	void release() throws IOException {
		if(initIn) {
			closeIn();
		}
		if(initOut) {
			closeOut();
		}
	}
	
	String getMsg() throws IOException {
		if(!initIn) {
			this.initIn();
		}
		return this.bfreader.readLine();
	}
	
	void writeMsg(String msg) throws IOException {
		if(!initOut) {
			this.initOut();
		}
		bfwriter.write(msg);
		bfwriter.flush();
	}
}
