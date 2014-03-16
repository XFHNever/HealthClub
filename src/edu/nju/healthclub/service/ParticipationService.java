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
	 * get �� set����
	 */
    public ParticipationDao getParticipationDao();
    public void setParticipationDao(ParticipationDao participationDao);
	
	/**
	 * ��ѯ�μӻ��¼
	 * @param member Member����
	 * @return �μӻ�ļ�¼�б�
	 */
	public List getParticipation(Member member);
	
	/**
	 * ��ȡ�û����еĻ��¼
	 * @return Participation������б�
	 */
	public List getAllParticipation();
	
	/**
	 * ��ȡ���ֲ���������������ʱ����������б�
	 * @return ʱ����������б�
	 */
	public List getDaily();
	/**
	 * Ԥ���μӻ
	 * @param participation Participation����
	 */
	public  void addNewParticipation(Participation participation);
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
