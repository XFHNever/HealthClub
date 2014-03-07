package edu.nju.healthclub.dao;

import edu.nju.healthclub.model.Manager;

public interface ManagerDao {
	/**
	 * 根据参数列名和这个列上的值查找Manager对象,如果找到则返回这个对象,否则返回null
	 * @param column 列名
	 * @param value  列值
	 * @return Manager对象
	 */
	public Manager find(String column,String value);
}
