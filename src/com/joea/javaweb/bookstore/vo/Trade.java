package com.joea.javaweb.bookstore.vo;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class Trade {

	// ���׶����Ӧ��Id
	private Integer tradeId;

	// ����ʱ��
	private Date tradeTime;

	// Trade �����Ķ��TradeItem
	private Set<TradeItem> items = new LinkedHashSet<>();

	// ��Trade������User��userId
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
