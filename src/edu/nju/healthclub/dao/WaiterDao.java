package edu.nju.healthclub.dao;

import edu.nju.healthclub.model.Waiter;

public interface WaiterDao {
	/**
	 * ���ݲ���������������ϵ�ֵ����Waiter����,����ҵ��򷵻��������,���򷵻�null
	 * @param column ����
	 * @param value  ��ֵ
	 * @return Waiter����
	 */
	public Waiter find(String column,String value);
}
