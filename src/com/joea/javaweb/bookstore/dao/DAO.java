package com.joea.javaweb.bookstore.dao;

import java.util.List;

public interface DAO<T> {

	/***
	 * 执行INSERT操作，返回插入后的记录的ID
	 * @param sql : 待执行的SQL语句
	 * @param args ：填充占位符的可变参数
	 * @return ：插入记录的ID
	 */
	public long insert(String sql,Object... args);
	
	/***
	 * 执行UPDATE操作，包括INTSERT(无返回值)，UPDATE,DELETE
	 * @param sql : 待执行的SQL语句
	 * @param args ：填充占位符的可变参数
	 */
	public void update(String sql,Object... args);

	/***
	 * 执行单条记录的查询，返回当前记录所对应的一个对象
	 * @param sql : 待执行的SQL语句
	 * @param args ：填充占位符的可变参数
	 * @return 当前记录所对应的一个对象
	 */
	public T query(String sql, Object... args);
	
	/***
	 * 执行多条记录的查询操作，返回与该记录对应的一个对象的列表
	 * @param sql  : 待执行的SQL语句
	 * @param args  ：填充占位符的可变参数
	 * @return 与该记录对应的一个对象的列表
	 */
	public List<T> queryForList(String sql,Object... args);
	
	/***
	 * 执行一个属性值或值的查询操作，如某一条记录的某一字段，或者查询某一个统计信息
	 * @param sql  : 待执行的SQL语句
	 * @param args  ：填充占位符的可变参数
	 * @return ：返回查询的一个属性或值
	 */
	public <V> V getSingleVal(String sql,Object... args);

	/***
	 * 执行批量更新操作
	 * @param sql : 待执行的SQL语句
	 * @param args  ：填充占位符的可变参数
	 */
	public void batch(String sql,Object[]...args);

	
}
