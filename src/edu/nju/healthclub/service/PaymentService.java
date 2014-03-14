package edu.nju.healthclub.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.MemberDao;
import edu.nju.healthclub.dao.PaymentDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Payment;
import edu.nju.healthclub.service.enuminfo.PAY_RESULT;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

public interface PaymentService {
	/*
	 * get �� set����
	 */
    public PaymentDao getPaymentDao();
    public void setPaymentDao(PaymentDao paymentDao);
    public MemberDao getMemberDao();
    public void setMemberDao(MemberDao memberDao);
	
	/**
	 * ��Ա֧��
	 * @param payment Payment����
	 * @return ֧����ö�ٽ��
	 */
	public PAY_RESULT addNewPayment(Payment payment);
	
	/**
	 * ��ѯ�ɷѼ�¼
	 * @param member Member����
	 * @return �ɷѼ�¼���б�.
	 */
	public List getPayments(Member member);
	
	/**
	 * ��ȡ�û����еĽɷѼ�¼
	 * @return Payment������б�
	 */
	public List getAllPayments();
	
	/**
	 * ��֤Payment���󣬷�����֤�����ö��
	 * @param payment Payment����
	 * @return ��֤�����ö��ֵ��
	 */
	public VALIDATE_RESULT validatePayment(Payment payment);
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
