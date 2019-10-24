package com.thzhima.mvcblog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.thzhima.mvcblog.beans.User;

@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate temp;
	
	public int add(String sql, Object... args) {
		return this.temp.update(sql, args);
	}
	
	public User selectOne(String sql, Object[] args, ResultSetExtractor<User> ext) {
		User user = null;
		user = this.temp.query(sql, args, ext);
		return user;
	}
	
	public User selectByNameAndPWD(User u) {
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
		
		return this.selectOne(sql, new Object[] {u.getUserName(), u.getPwd()}, ext);
		
	}

	public boolean add(String userName, String pwd) {
		String sql = "insert into t_users (user_id, user_name, pwd)"
				+ " values(seq_users.nextval, ?, ?)";
		
		if(1==this.add(sql, userName, pwd)) {
			return true;
		}else{
			return false;
		}
	}

}
