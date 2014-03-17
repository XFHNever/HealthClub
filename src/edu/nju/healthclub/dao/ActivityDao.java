package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Activity;

public interface ActivityDao {
	
	public long getFieldUsage(String field);
	/**
	 * 根据参数列名和这个列上的值查找Activity对象,如果找到则返回这个对象,否则返回null
	 * @param column 列名
	 * @param value  列值
	 * @return Activity对象
	 */
	public Activity find(String column,String value);
	
	/**
	 * 查询所有的Activity对象
	 * @return Activity对象的列表
	 */
	public List finAll();
	
	/**
	 * 向数据库插入一条Activity记录
	 * @param activity Activity对象。
	 */
	public void save(Activity activity);
}
