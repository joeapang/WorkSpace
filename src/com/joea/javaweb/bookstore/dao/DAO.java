package com.joea.javaweb.bookstore.dao;

import java.util.List;

public interface DAO<T> {

	/***
	 * ִ��INSERT���������ز����ļ�¼��ID
	 * @param sql : ��ִ�е�SQL���
	 * @param args �����ռλ���Ŀɱ����
	 * @return �������¼��ID
	 */
	public long insert(String sql,Object... args);
	
	/***
	 * ִ��UPDATE����������INTSERT(�޷���ֵ)��UPDATE,DELETE
	 * @param sql : ��ִ�е�SQL���
	 * @param args �����ռλ���Ŀɱ����
	 */
	public void update(String sql,Object... args);

	/***
	 * ִ�е�����¼�Ĳ�ѯ�����ص�ǰ��¼����Ӧ��һ������
	 * @param sql : ��ִ�е�SQL���
	 * @param args �����ռλ���Ŀɱ����
	 * @return ��ǰ��¼����Ӧ��һ������
	 */
	public T query(String sql, Object... args);
	
	/***
	 * ִ�ж�����¼�Ĳ�ѯ������������ü�¼��Ӧ��һ��������б�
	 * @param sql  : ��ִ�е�SQL���
	 * @param args  �����ռλ���Ŀɱ����
	 * @return ��ü�¼��Ӧ��һ��������б�
	 */
	public List<T> queryForList(String sql,Object... args);
	
	/***
	 * ִ��һ������ֵ��ֵ�Ĳ�ѯ��������ĳһ����¼��ĳһ�ֶΣ����߲�ѯĳһ��ͳ����Ϣ
	 * @param sql  : ��ִ�е�SQL���
	 * @param args  �����ռλ���Ŀɱ����
	 * @return �����ز�ѯ��һ�����Ի�ֵ
	 */
	public <V> V getSingleVal(String sql,Object... args);

	/***
	 * ִ���������²���
	 * @param sql : ��ִ�е�SQL���
	 * @param args  �����ռλ���Ŀɱ����
	 */
	public void batch(String sql,Object[]...args);

	
}
