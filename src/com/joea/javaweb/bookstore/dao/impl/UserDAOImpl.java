package com.joea.javaweb.bookstore.dao.impl;

import com.joea.javaweb.bookstore.dao.UserDao;
import com.joea.javaweb.bookstore.vo.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDao {

	@Override
	public User getUser(String username) {
		String sql="SELECT * FROM userinfo WHERE username=?";
		
		return query(sql, username);
	}

}
