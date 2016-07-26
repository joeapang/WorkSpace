package com.joea.javaweb.bookstore.dao;

import java.util.Collection;
import java.util.Set;

import com.joea.javaweb.bookstore.vo.TradeItem;

public interface TradeItemDAO {

	/***
	 * 批量保存TradeItem对象
	 * @param items
	 */
	public abstract void bathSave(Collection<TradeItem> items);
	
	/***
	 * 根据tradeId获取和其关联的TradeItem对象
	 * @param tradeId
	 * @return
	 */
	public abstract Set<TradeItem> getTradeItemWithTradeId(Integer tradeId);
}
