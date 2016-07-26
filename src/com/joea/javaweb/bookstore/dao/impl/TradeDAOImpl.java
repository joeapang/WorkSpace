package com.joea.javaweb.bookstore.dao.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import com.joea.javaweb.bookstore.dao.TradeDAO;
import com.joea.javaweb.bookstore.vo.Trade;

public class TradeDAOImpl extends BaseDAO<Trade> implements TradeDAO {

	@Override
	public void insert(Trade trade) {
		String sql = "INSERT INTO trade (userid,tradetime) VALUES(?,?)";
		long tradeId=insert(sql, trade.getUserId(), trade.getTradeTime());
		trade.setTradeId((int)tradeId);
		
	}

	@Override
	public Set<Trade> getTradesWithUserId(Integer userId) {

		String sql="SELECT * FROM trade WHERE userId=? ORDER BY tradeTime DESC";
		return new LinkedHashSet<>(queryForList(sql, userId));
	}

}
