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
	 * get 和 set 方法
	 */
	public WaiterDao getWaiterDao();
	public void setWaiterDao(WaiterDao waiterDao);

	/**
	 * 通过id验证服务员用户,如果验证查找失败，则返回null。
	 * @param waiterid 俱乐部服务员Id
	 * @return Waiter对象
	 */
	public Waiter validateWaiter(String waiterid);

	
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
