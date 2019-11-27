package com.thzhima.goover.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriaTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
        FileOutputStream target = null;
        FileInputStream fin = null;
        ByteArrayOutputStream bout = null;
        ByteArrayInputStream bin = null;
        
       // target = new FileOutputStream("/home/wangrui/User");
        bout = new ByteArrayOutputStream();
        out = new ObjectOutputStream(bout);
        out.writeObject(new User());
        
       // fin = new FileInputStream("/home/wangrui/User");
       byte[] buf = bout.toByteArray();
        bin = new ByteArrayInputStream(buf);
        in = new ObjectInputStream(bin);
        Object o = in.readObject();
        System.out.println(o);
     
	}
}
