package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Session;

public interface SessionDao {
	/**
	 * ���ݲ���������������ϵ�ֵ����Session����,����ҵ��򷵻��������,���򷵻�null
	 * @param column ����
	 * @param value  ��ֵ
	 * @return Session����
	 */
	public Session find(String column,String value);
	
	/**
	 * ��ѯ���е�Session����
	 * @return Session������б�
	 */
	public List finAll();
	
	/**
	 * �����ݿ����һ��Session��¼
	 * @param session Session����
	 */
	public void save(Session session);
}
