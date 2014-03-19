package edu.nju.healthclub.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.MemberDao;
import edu.nju.healthclub.dao.ParticipationDao;
import edu.nju.healthclub.dao.PaymentDao;
import edu.nju.healthclub.dao.SessionDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Participation;
import edu.nju.healthclub.model.Payment;
import edu.nju.healthclub.model.Session;
import edu.nju.healthclub.service.enuminfo.PAY_RESULT;
import edu.nju.healthclub.service.enuminfo.REGISTER_RESULT;
import edu.nju.healthclub.service.enuminfo.RESERVE_RESULT;
import edu.nju.healthclub.service.enuminfo.UPDATE_RESULT;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

public interface MemberService {
	/*
	 * get �� set����
	 */
	public MemberDao getMemberDao();
	public void setMemberDao(MemberDao memberDao);

	public List getAll();
	
	public List getSex();
	
	public List getAge();
	/**
	 * ͨ��id��֤�û�,�����֤����ʧ�ܣ��򷵻�null��
	 * @param memberid ��ԱId
	 * @return Member����
	 */
	public Member validateMember(String memberid);
	
	/**
	 * ע���û�
	 * @param member Member����
	 * @return ע������ö��ֵ.
	 */
	public REGISTER_RESULT registerMember(Member member);
	
	/**
	 * ��֤���»�Ա.
	 * @param member Member����
	 * @return ��֤�����ö��ֵ
	 */
	public VALIDATE_RESULT validateUpdateMember(Member member);
	
	/**
	 * ��֤�Ƿ�Ϊ�������֣���������֣����ظ���ֵ�����򷵻�null
	 * @param number Ҫ��֤��String
	 * @return �ַ������������
	 */
	public Integer validateNumber(String number);
	
	/**
	 * �����û���Ϣ.
	 * @param member Member����
	 * @return ��Ϣ���µĽ��
	 */
	public UPDATE_RESULT updateMember(Member member);
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
	/**
	 * ȡ����Ա�ʸ�
	 * @param member Member����
	 */
	public void cancelQualification(Member member);
	


}
