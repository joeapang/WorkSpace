package com.joea.javaweb.bookstore.vo;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class Trade {

	// 交易对象对应的Id
	private Integer tradeId;

	// 交易时间
	private Date tradeTime;

	// Trade 关联的多个TradeItem
	private Set<TradeItem> items = new LinkedHashSet<>();

	// 和Trade关联的User的userId
	private Integer userId;

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public Set<TradeItem> getItems() {
		return items;
	}

	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", tradeTime=" + tradeTime + ", items=" + items + ", userId=" + userId
				+ "]";
	}

}
