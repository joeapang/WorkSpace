package com.joea.javaweb.bookstore.dao;

import com.joea.javaweb.bookstore.vo.Account;

public interface AccountDAO {

	/***
	 * 根据accountid获取对应的Account对象
	 * @param id
	 * @return
	 */
	public abstract Account get(Integer accountid);
	
	/**
	 * 根据传入的accountid和amount更新指定账户的余额
	 * @param accountid
	 * @param amount
	 */
	public abstract void updateBanlance(Integer accountid,float amount);
}
