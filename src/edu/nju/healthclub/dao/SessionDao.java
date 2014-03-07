package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Session;

public interface SessionDao {
	/**
	 * 根据参数列名和这个列上的值查找Session对象,如果找到则返回这个对象,否则返回null
	 * @param column 列名
	 * @param value  列值
	 * @return Session对象
	 */
	public Session find(String column,String value);
	
	/**
	 * 查询所有的Session对象
	 * @return Session对象的列表
	 */
	public List finAll();
	
	/**
	 * 向数据库插入一条Session记录
	 * @param session Session对象。
	 */
	public void save(Session session);
}
