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
	 * get 和 set 方法
	 */
	public ManagerDao getManagerDao();
	public void setManagerDao(ManagerDao managerDao);
	
	/**
	 * 通过id验证经理用户,如果验证查找失败，则返回null。
	 * @param managerid 俱乐部经理Id
	 * @return Manager对象
	 */
	public Manager validateManager(String managerid);
	
	
	/**
	 * 发送错误信息
	 * @param message 信息内容
	 * @param req  HttpServletRequest
	 * @param resp HttpServletResponse
	 */
	public void sentErrorMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException;

	/**
	 * 发送信息
	 * @param message 信息内容
	 * @param req  HttpServletRequest
	 * @param resp HttpServletResponse
	 */
	public void sentMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException;
}
