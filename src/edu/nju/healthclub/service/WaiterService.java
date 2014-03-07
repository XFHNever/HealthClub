package edu.nju.healthclub.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.ActivityDao;
import edu.nju.healthclub.dao.WaiterDao;
import edu.nju.healthclub.model.Activity;
import edu.nju.healthclub.model.Waiter;

public interface WaiterService {
	/*
	 * get �� set ����
	 */
	public WaiterDao getWaiterDao();
	public void setWaiterDao(WaiterDao waiterDao);

	/**
	 * ͨ��id��֤����Ա�û�,�����֤����ʧ�ܣ��򷵻�null��
	 * @param waiterid ���ֲ�����ԱId
	 * @return Waiter����
	 */
	public Waiter validateWaiter(String waiterid);

	
	/**
	 * ���ʹ�����Ϣ
	 * @param message ��Ϣ����
	 * @param req  HttpServletRequest
	 * @param resp HttpServletResponse
	 */
	public void sentErrorMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException;

	/**
	 * ������Ϣ
	 * @param message ��Ϣ����
	 * @param req  HttpServletRequest
	 * @param resp HttpServletResponse
	 */
	public void sentMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException;
}
