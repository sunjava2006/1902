package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thzhima.advance.entity.User;

/**
 * @author wangrui
 *
 */
public class UserDAO {

	/**
	 * 根据用户名和密码，查询用户。
	 * @param userName 用户名
	 * @param pwd   密码
	 * @return 当能够查询到用户时，返回User对象。否则返回null。
	 * @throws SQLException
	 */
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


	public boolean add(User u) throws SQLException {
		boolean ok = false;
		String sql = "insert into t_users(id,user_name,pwd)values(seq_users.nextval,?,?)";
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			stm.setString(1, u.getUserName()); // 设置参数，索引从1开始。
			stm.setObject(2, u.getPwd());
			
			int count = stm.executeUpdate();// 所有DDL操作，都调用executeUpdate()方法。
			if(1 == count) {
				ok = true;
			}
			conn.commit();
		}catch(SQLException ex) {
			conn.rollback();
			ex.printStackTrace();
		}finally {
			if(null == stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		return ok;
	}
	
	public boolean deleteByID(Integer ... ids) throws SQLException {
		boolean ok = true;
		String sql = "delete from t_users where id=?";
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			if(null != ids) {
				for(int i=0;i<ids.length;i++) {
					int id = ids[i];
					stm.setInt(1, id);
					int count = stm.executeUpdate();
					if(count<0) {
						ok = false;
						conn.rollback();
						break;
					}
				}
			}
			if(ok) {
				conn.commit();
			}
			
		} catch (SQLException e) {
			conn.rollback();
			ok = false;
			e.printStackTrace();
		} finally {
			if(null == stm) {
				stm.close();
			}
			if(null != conn) {
				conn.setAutoCommit(true);
				conn.close();
			}
		}
		
		return ok;
	}
	
	
}
