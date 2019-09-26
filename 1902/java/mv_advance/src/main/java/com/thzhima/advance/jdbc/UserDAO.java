package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thzhima.advance.entity.User;

public class UserDAO {

	public User find(String userName, String pwd) throws SQLException {
		User u = null;
		String sql = "select * from t_users "
				   + "where user_name=? and pwd=?";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, userName);
			stm.setString(2, pwd);
			rst = stm.executeQuery();
			if(rst.next()) {
				Integer id = rst.getInt("id");
				String name = rst.getString("user_name");
				String password = rst.getString("pwd");
				
				u = new User(id, name, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}

		return u;
	}
	
	
	
}
