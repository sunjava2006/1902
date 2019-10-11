package com.thzhima.advance.nio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOperation {

	public static void main(String[] args) throws IOException, URISyntaxException {
		FileChannel fc = null;
		
		try {
			Path path = Paths.get(new URI("file:///home/wangrui/aaaa.txt"));
			//RandomAccessFile raf = new RandomAccessFile("/home/wangrui/aaa.txt", "rw");
			fc = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);//raf.getChannel();
			String msg = "大家好";
			ByteBuffer buffer = ByteBuffer.allocate(msg.getBytes().length+10);
			
			System.out.println(buffer.capacity());
			System.out.println(buffer.position());
			System.out.println(buffer.limit());
			
			buffer.put(msg.getBytes());
			System.out.println("-------------------------------------");
			System.out.println(buffer.capacity());
			System.out.println(buffer.position());
			System.out.println(buffer.limit());
			
			buffer.flip(); // 
			System.out.println("-------------------------------------");
			System.out.println(buffer.capacity());
			System.out.println(buffer.position());
			System.out.println(buffer.limit());
			
			fc.write(buffer);
			System.out.println("-------------------------------------");
			System.out.println(buffer.capacity());
			System.out.println(buffer.position());
			System.out.println(buffer.limit());
			
			buffer.clear();
			System.out.println("-------------------------------------");
			System.out.println(buffer.capacity());
			System.out.println(buffer.position());
			System.out.println(buffer.limit());
			
			
			int count = fc.read(buffer);
			String s = new String(buffer.array());
			System.out.println(s);
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fc.close();
		}
		
	}
}
