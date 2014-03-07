package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Coach;

public interface CoachDao {
	/**
	 * 根据参数列名和这个列上的值查找Coach对象,如果找到则返回这个对象,否则返回null
	 * @param column 列名
	 * @param value  列值
	 * @return Coach对象
	 */
	public Coach find(String column,String value);
	
	/**
	 * 查询所有的Coach对象
	 * @return Coach对象的列表
	 */
	public List finAll();
}
