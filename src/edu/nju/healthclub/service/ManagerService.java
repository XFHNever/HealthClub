package edu.nju.healthclub.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.ManagerDao;
import edu.nju.healthclub.model.Manager;

public interface ManagerService {
	/*
	 * get �� set ����
	 */
	public ManagerDao getManagerDao();
	public void setManagerDao(ManagerDao managerDao);
	
	/**
	 * ͨ��id��֤�����û�,�����֤����ʧ�ܣ��򷵻�null��
	 * @param managerid ���ֲ�����Id
	 * @return Manager����
	 */
	public Manager validateManager(String managerid);
	
	
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
