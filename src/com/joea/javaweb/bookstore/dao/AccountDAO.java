package com.joea.javaweb.bookstore.dao;

import com.joea.javaweb.bookstore.vo.Account;

public interface AccountDAO {

	/***
	 * ����accountid��ȡ��Ӧ��Account����
	 * @param id
	 * @return
	 */
	public abstract Account get(Integer accountid);
	
	/**
	 * ���ݴ����accountid��amount����ָ���˻������
	 * @param accountid
	 * @param amount
	 */
	public abstract void updateBanlance(Integer accountid,float amount);
}
