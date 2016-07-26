package com.joea.javaweb.bookstore.dao.impl;

import com.joea.javaweb.bookstore.dao.AccountDAO;
import com.joea.javaweb.bookstore.vo.Account;

public class AccountDAOImpl extends BaseDAO<Account> implements AccountDAO{

	@Override
	public Account get(Integer accountid) {

		String sql="SELECT * FROM account WHERE accountid=?";
		return query(sql, accountid);
	}

	@Override
	public void updateBanlance(Integer accountid, float amount) {
		// TODO Auto-generated method stub
		String sql="UPDATE account SET balance=balance-? WHERE accountid=?";
		update(sql, amount,accountid);
	}

}
