package com.joea.javaweb.bookstore.dao;

import com.joea.javaweb.bookstore.vo.User;

public interface UserDao {

	/**
	 * �����û�����ȡ��Ӧ��User����
	 * @param username
	 * @return
	 */
	public abstract User getUser(String username);
}
