package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Payment;

public interface PaymentDao {
	/**
	 * ���ݲ���������������ϵ�ֵ����Payment����,����ҵ��򷵻��������,���򷵻�null
	 * @param column ����
	 * @param value  ��ֵ
	 * @return Payment����
	 */
	public Payment find(String column,String value);
	
	/**
	 * ��ѯ���е�Payment����
	 * @return Payment������б�
	 */
	public List finAll();
	
	/**
	 * �����ݿ����һ��Payment��¼
	 * @param payment Payment����
	 */
	public void save(Payment payment);
}
