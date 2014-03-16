package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Member;

public interface MemberDao {
	
	
	public List getSex();
	/**
	 * 向数据库插入一条Member记录
	 * @param member Member对象。
	 */
	public void save(Member member);
	/**
	 * 根据参数列名和这个列上的值查找Member对象,如果找到则返回这个对象,否则返回null
	 * @param column 列名
	 * @param value  列值
	 * @return Member对象
	 */
    public Member find(String column,String value);
    
    /**
     * 根据id更新Member表的一条记录
     * @param member Member对象
     */
    public void updateByMemberid(Member member);
    
    /**
     * 删除一个Member对象
     * @param member Member对象.
     */
    public void delete(Member member);
    
    /**
     * 获取所有的Member
     * @return Member对象的list。
     */
    @SuppressWarnings("rawtypes")
	public List findAll();
}
