package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Coach;

public interface CoachDao {
	/**
	 * ���ݲ���������������ϵ�ֵ����Coach����,����ҵ��򷵻��������,���򷵻�null
	 * @param column ����
	 * @param value  ��ֵ
	 * @return Coach����
	 */
	public Coach find(String column,String value);
	
	/**
	 * ��ѯ���е�Coach����
	 * @return Coach������б�
	 */
	public List finAll();
}
