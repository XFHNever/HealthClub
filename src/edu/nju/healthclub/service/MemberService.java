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
	 * get 和 set方法
	 */
	public MemberDao getMemberDao();
	public void setMemberDao(MemberDao memberDao);

	public List getAll();
	
	public List getSex();
	
	/**
	 * 通过id验证用户,如果验证查找失败，则返回null。
	 * @param memberid 会员Id
	 * @return Member对象
	 */
	public Member validateMember(String memberid);
	
	/**
	 * 注册用户
	 * @param member Member对象
	 * @return 注册结果的枚举值.
	 */
	public REGISTER_RESULT registerMember(Member member);
	
	/**
	 * 验证更新会员.
	 * @param member Member对象
	 * @return 验证结果的枚举值
	 */
	public VALIDATE_RESULT validateUpdateMember(Member member);
	
	/**
	 * 验证是否为数字数字，如果是数字，返回该数值，否则返回null
	 * @param number 要验证的String
	 * @return 字符串对象的数字
	 */
	public Integer validateNumber(String number);
	
	/**
	 * 更新用户信息.
	 * @param member Member对象
	 * @return 信息更新的结果
	 */
	public UPDATE_RESULT updateMember(Member member);
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
	/**
	 * 取消会员资格
	 * @param member Member对象
	 */
	public void cancelQualification(Member member);
	


}
