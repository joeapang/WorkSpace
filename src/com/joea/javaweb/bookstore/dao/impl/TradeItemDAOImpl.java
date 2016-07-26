package com.joea.javaweb.bookstore.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.joea.javaweb.bookstore.dao.TradeItemDAO;
import com.joea.javaweb.bookstore.vo.TradeItem;

public class TradeItemDAOImpl extends BaseDAO<TradeItem> implements TradeItemDAO {

	@Override
	public void bathSave(Collection<TradeItem> items) {

		String sql = "INSERT INTO tradeitem(bookid, quantity, tradeid) " + "VALUES(?,?,?)";
		Object[][] params = new Object[items.size()][3];
		List<TradeItem> tradeItems = new ArrayList<TradeItem>(items);
		for (int i = 0; i < tradeItems.size(); i++) {
			params[i][0] = tradeItems.get(i).getBookId();
			params[i][1] = tradeItems.get(i).getQuantity();
			params[i][2] = tradeItems.get(i).getTradeId();
		}
		batch(sql, params);
	}

	@Override
	public Set<TradeItem> getTradeItemWithTradeId(Integer tradeId) {
		String sql="SELECT * FROM tradeitem WHERE tradeId=?";
		return new HashSet<>(queryForList(sql, tradeId)) ;
	}

}
