package com.thzhima.mvcblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
