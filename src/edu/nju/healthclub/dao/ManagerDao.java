package edu.nju.healthclub.dao;

import edu.nju.healthclub.model.Manager;

public interface ManagerDao {
	/**
	 * ���ݲ���������������ϵ�ֵ����Manager����,����ҵ��򷵻��������,���򷵻�null
	 * @param column ����
	 * @param value  ��ֵ
	 * @return Manager����
	 */
	public Manager find(String column,String value);
}
