package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Participation;

public interface ParticipationDao {
	/**
	 * 根据参数列名和这个列上的值查找Participation对象,如果找到则返回这个对象,否则返回null
	 * @param column 列名
	 * @param value  列值
	 * @return Participation对象
	 */
	public Participation find(String column,String value);
	
	/**
	 * 查询所有的Participation对象
	 * @return Participation对象的列表
	 */
	@SuppressWarnings("rawtypes")
	public List finAll();
	

	public List findDaily();
	/**
	 * 通过关键字搜索Participation,返回Participation对象集合
	 * @param column 列名
	 * @param value 列值
	 * @return Participation对象的集合
	 */
	@SuppressWarnings("rawtypes")
	public List findByKey(String column,String value);
	
	/**
	 * 向数据库插入一条Participation记录
	 * @param participation Participation对象。
	 */
	public void save(Participation participation);
}
