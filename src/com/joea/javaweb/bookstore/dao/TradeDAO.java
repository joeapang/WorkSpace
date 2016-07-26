package com.joea.javaweb.bookstore.dao;

import java.util.Set;

import com.joea.javaweb.bookstore.vo.Trade;

public interface TradeDAO {

	/***
	 * �����ݱ��в���Trade����
	 * 
	 * @param trade
	 */
	public abstract void insert(Trade trade);

	/**
	 * ����userId��ȡ���������Trade�ļ���
	 * @param userId
	 * @return
	 */
	public abstract Set<Trade> getTradesWithUserId(Integer userId);
}
