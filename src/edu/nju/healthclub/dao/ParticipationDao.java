package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Participation;

public interface ParticipationDao {
	/**
	 * ���ݲ���������������ϵ�ֵ����Participation����,����ҵ��򷵻��������,���򷵻�null
	 * @param column ����
	 * @param value  ��ֵ
	 * @return Participation����
	 */
	public Participation find(String column,String value);
	
	/**
	 * ��ѯ���е�Participation����
	 * @return Participation������б�
	 */
	@SuppressWarnings("rawtypes")
	public List finAll();
	
	/**
	 * �����ݿ����һ��Participation��¼
	 * @param participation Participation����
	 */
	public void save(Participation participation);
}
