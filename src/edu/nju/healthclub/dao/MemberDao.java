package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Member;

public interface MemberDao {
	
	public List getAge();
	public List getSex();
	/**
	 * �����ݿ����һ��Member��¼
	 * @param member Member����
	 */
	public void save(Member member);
	/**
	 * ���ݲ���������������ϵ�ֵ����Member����,����ҵ��򷵻��������,���򷵻�null
	 * @param column ����
	 * @param value  ��ֵ
	 * @return Member����
	 */
    public Member find(String column,String value);
    
    /**
     * ����id����Member���һ����¼
     * @param member Member����
     */
    public void updateByMemberid(Member member);
    
    /**
     * ɾ��һ��Member����
     * @param member Member����.
     */
    public void delete(Member member);
    
    /**
     * ��ȡ���е�Member
     * @return Member�����list��
     */
    @SuppressWarnings("rawtypes")
	public List findAll();
}
