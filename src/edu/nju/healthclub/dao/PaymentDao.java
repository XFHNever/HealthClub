package edu.nju.healthclub.dao;

import java.util.List;

import edu.nju.healthclub.model.Payment;

public interface PaymentDao {
	/**
	 * 根据参数列名和这个列上的值查找Payment对象,如果找到则返回这个对象,否则返回null
	 * @param column 列名
	 * @param value  列值
	 * @return Payment对象
	 */
	public Payment find(String column,String value);
	
	/**
	 * 查询所有的Payment对象
	 * @return Payment对象的列表
	 */
	public List finAll();
	
	/**
	 * 向数据库插入一条Payment记录
	 * @param payment Payment对象。
	 */
	public void save(Payment payment);
}
