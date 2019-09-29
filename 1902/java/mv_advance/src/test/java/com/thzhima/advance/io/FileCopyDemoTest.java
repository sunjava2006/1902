package com.thzhima.advance.io;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

public class FileCopyDemoTest extends TestCase {

	public FileCopyDemoTest(String name) {
		super(name);
	}

//	public void testCopy() throws IOException {
//		String source = "/home/wangrui/下载/girl.jpeg";
//		String target = "/home/wangrui/下载/a/girl_bockup.jpeg";
//		boolean ok = FileCopyDemo.copy(source, target);
//		
//		TestCase.assertEquals(true, ok);
//	
//	}
	
	public void testCopy2() {
		System.out.println("-----------------------------");
		File f = new File("/home/wangrui/下载/a/girl2.jpeg");
		File f2= new File("/home/wangrui/下载/a/b/girl2.jpeg");
		boolean ok = f.renameTo(f2);
		
		TestCase.assertEquals(true, ok);
		
	}

}
