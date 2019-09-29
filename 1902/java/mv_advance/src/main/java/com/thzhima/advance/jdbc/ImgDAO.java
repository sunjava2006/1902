package com.thzhima.advance.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImgDAO {

	public static void add(String imgName) throws SQLException, IOException {
		Connection conn = null;
		PreparedStatement stm = null;
		String sql = "insert into t_imgs values(?, ?)";
		File f = new File(imgName);
		String name = f.getName();
		FileInputStream in = null;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			in = new FileInputStream(f);
			stm = conn.prepareStatement(sql);
			stm.setBlob(1, in);
			stm.setString(2, name);
			stm.executeUpdate();
			
			conn.commit();
			
			//----------------------作业 ：实现 从数据库中读出文件，并另存。------------------------------
//			ResultSet rst = stm.executeQuery();
//			Blob b = rst.getBlob(1);
//			InputStream input = b.getBinaryStream();
			
			
			
			
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			if(null != in) {
				in.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		add("/home/wangrui/下载/girl.jpeg");
	}
}
