package com.thzhima.mvcblog.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.thzhima.mvcblog.beans.User;
import com.thzhima.mvcblog.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	
	public boolean registUser(String userName, String pwd) {
		String sql = "insert into t_users (user_id, user_name, pwd)"
				+ " values(seq_users.nextval, ?, ?)";
		
		if(1==this.dao.add(sql, userName, pwd)) {
			return true;
		}else{
			return false;
		}
	}
	
	public User login(User u) {
		String  sql = "select * from t_users where user_name=? and pwd=?";
		
		ResultSetExtractor<User> ext = new ResultSetExtractor<User>() {
			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User u = null;
				if(rs.next()) {
					Integer userID = rs.getInt(1);
					String userName = rs.getString(2);
					String pwd = rs.getString(3);
					u = new User(userID, userName, pwd);
				}
				return u;
			}
		};
		
		return this.dao.selectOne(sql, new Object[] {u.getUserName(), u.getPwd()}, ext);
		
	}
}
