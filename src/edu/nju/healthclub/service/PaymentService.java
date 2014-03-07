package edu.nju.healthclub.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.PaymentDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Payment;
import edu.nju.healthclub.service.enuminfo.PAY_RESULT;

public interface PaymentService {
	/*
	 * get 和 set方法
	 */
    public PaymentDao getPaymentDao();
    public void setPaymentDao(PaymentDao paymentDao);
	
	/**
	 * 会员支付
	 * @param payment Payment对象
	 * @return 支付的枚举结果
	 */
	public PAY_RESULT addNewPayment(Payment payment);
	
	/**
	 * 查询缴费记录
	 * @param member Member对象
	 * @return 缴费记录的列表.
	 */
	public List getPayments(Member member);
	
	/**
	 * 获取用户所有的缴费记录
	 * @return Payment对象的列表
	 */
	public List getAllPayments();
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
