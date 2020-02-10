package com.wangrui.adv.jdbc2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PictureDAO {

	public static int save(String name) throws Exception {
		int count = -1;
		FileInputStream inputStream = null;
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			File f = new File(name);
			inputStream = new FileInputStream(f);
			
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement("insert into pictures(name,picture)values(?,?)");
			stm.setString(1, f.getName());
			stm.setBlob(2, inputStream);
			
			count= stm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != inputStream)
				inputStream.close();
			if(null != stm)
				stm.close();
			if(null != conn)
				conn.close();
		}
		return count;
	}
	
	
	public static byte[] get(String name) throws SQLException {
		byte[] data = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement("select * from pictures where name=?");
			stm.setString(1, name);
			rst = stm.executeQuery();
			while(rst.next()) {
//				String fname = rst.getString(1);
				data = rst.getBytes(2);// 取出数据库中存放的二进制数据
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm)
				stm.close();
			if(null != conn)
				conn.close();
		}
		return data;
	}
	
	public static void main(String[] args) throws Exception {
//		int c = save("/home/wangrui/下载/3.jpeg");
//		System.out.println(c);
		
		byte[] data = get("3.jpeg");
		FileOutputStream fout = new FileOutputStream("/home/wangrui/picture.jpeg");
		fout.write(data);
		fout.close();
	}
}
