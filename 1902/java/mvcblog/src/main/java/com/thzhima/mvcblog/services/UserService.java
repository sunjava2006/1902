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
		return dao.add(userName, pwd);
	}
	
	public User login(User u) {
		return this.dao.selectByNameAndPWD(u);
	}
}
