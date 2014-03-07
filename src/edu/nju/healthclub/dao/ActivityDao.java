package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Activity;

public interface ActivityDao {
	/**
	 * ���ݲ���������������ϵ�ֵ����Activity����,����ҵ��򷵻��������,���򷵻�null
	 * @param column ����
	 * @param value  ��ֵ
	 * @return Activity����
	 */
	public Activity find(String column,String value);
	
	/**
	 * ��ѯ���е�Activity����
	 * @return Activity������б�
	 */
	public List finAll();
	
	/**
	 * �����ݿ����һ��Activity��¼
	 * @param activity Activity����
	 */
	public void save(Activity activity);
}
