package edu.nju.healthclub.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.ParticipationDao;
import edu.nju.healthclub.dao.SessionDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Participation;
import edu.nju.healthclub.model.Session;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

public interface SessionService {
	/*
	 * set �� get ����
	 */
	public SessionDao getSessionDao();
	public void setSessionDao(SessionDao sessionDao);
	public ParticipationDao getParticipationDao();
	public void setParticipationDao(ParticipationDao participationDao);
	
	/**
	 * �½�һ�������
	 * @param session Session����
	 */
	public void addNewSession(Session session); 
	
	public VALIDATE_RESULT validateSession();
	
	/**
	 * ��ԱԤ��һ�����λ
	 * @param member Member����
	 * @param session Session����
	 */
	public void reserveSession(Member member,Session session);
	
	/**
	 * ��ȡ���еĻ���Ρ�
	 * @return Session������б�
	 */
	public List getAllSessions();
	
	/**
	 * ��ȡ�ƶ��û��μӵĻ����
	 * @param member Member����
	 * @return Session������б�
	 */
	public List getSessions(Member member);
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
