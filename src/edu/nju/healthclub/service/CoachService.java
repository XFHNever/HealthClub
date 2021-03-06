package edu.nju.healthclub.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.CoachDao;

public interface CoachService {
	
	/*
	 * get和set方法
	 */
	public CoachDao getCoachDao();
	public void setCoachDao(CoachDao coachDao);
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
