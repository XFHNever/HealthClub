package edu.nju.healthclub.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.SessionDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Participation;
import edu.nju.healthclub.model.Session;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

public interface SessionService {
	/*
	 * set 和 get 方法
	 */
	public SessionDao getSessionDao();
	public void setSessionDao(SessionDao sessionDao);
	
	/**
	 * 新建一个活动场次
	 * @param session Session对象
	 */
	public void addNewSession(Session session); 
	
	public VALIDATE_RESULT validateSession();
	
	/**
	 * 会员预定一个场次活动，返回一个参与活动记录.
	 * @param session Session对象
	 * @return Participation对象
	 */
	public Participation reserveSession(Session session);
	
	/**
	 * 获取所有的活动场次。
	 * @return Session对象的列表
	 */
	public List getAllSessions();
	
	/**
	 * 获取制定用户参加的活动场次
	 * @param member Member对象
	 * @return Session对象的列表
	 */
	public List getSessions(Member member);
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
