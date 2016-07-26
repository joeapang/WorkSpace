package com.joea.javaweb.bookstore.dao;

import java.util.Collection;
import java.util.Set;

import com.joea.javaweb.bookstore.vo.TradeItem;

public interface TradeItemDAO {

	/***
	 * ��������TradeItem����
	 * @param items
	 */
	public abstract void bathSave(Collection<TradeItem> items);
	
	/***
	 * ����tradeId��ȡ���������TradeItem����
	 * @param tradeId
	 * @return
	 */
	public abstract Set<TradeItem> getTradeItemWithTradeId(Integer tradeId);
}
