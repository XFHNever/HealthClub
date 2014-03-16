package edu.nju.healthclub.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.ParticipationDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Participation;

public interface ParticipationService {
	/*
	 * get 和 set方法
	 */
    public ParticipationDao getParticipationDao();
    public void setParticipationDao(ParticipationDao participationDao);
	
	/**
	 * 查询参加活动记录
	 * @param member Member对象
	 * @return 参加活动的记录列表
	 */
	public List getParticipation(Member member);
	
	/**
	 * 获取用户所有的活动记录
	 * @return Participation对象的列表
	 */
	public List getAllParticipation();
	
	/**
	 * 获取俱乐部日总人数。返回时间和人数的列表。
	 * @return 时间和人数的列表。
	 */
	public List getDaily();
	/**
	 * 预定参加活动
	 * @param participation Participation对象
	 */
	public  void addNewParticipation(Participation participation);
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
