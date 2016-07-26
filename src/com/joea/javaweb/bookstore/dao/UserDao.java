package com.joea.javaweb.bookstore.dao;

import com.joea.javaweb.bookstore.vo.User;

public interface UserDao {

	/**
	 * 根据用户名获取对应的User对象
	 * @param username
	 * @return
	 */
	public abstract User getUser(String username);
}
