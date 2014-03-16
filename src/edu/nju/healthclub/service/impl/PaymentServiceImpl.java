package edu.nju.healthclub.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.MemberDao;
import edu.nju.healthclub.dao.PaymentDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Payment;
import edu.nju.healthclub.service.PaymentService;
import edu.nju.healthclub.service.enuminfo.MEMBER_STATE;
import edu.nju.healthclub.service.enuminfo.PAY_RESULT;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

public class PaymentServiceImpl implements PaymentService{
    private PaymentDao paymentDao;
    private MemberDao memberDao;
	
	@Override
	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	@Override
	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}
	
	@Override
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	@Override
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public PAY_RESULT addNewPayment(Payment payment) {
		Member member = memberDao.find("memberid", payment.getMemberid());
		
		if(member == null) {
			return PAY_RESULT.支付失败;
		}
		
		float newBalance = member.getBalance() + (float)payment.getQuantity();
		
		if(!member.getState().equals(MEMBER_STATE.USING.toString())) {
			member.setState(MEMBER_STATE.USING.toString());
		}
		member.setBalance(newBalance);
		memberDao.updateByMemberid(member);
		
		paymentDao.save(payment);
		return PAY_RESULT.支付成功;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPayments(Member member) {
		return paymentDao.findByKey("memberid", member.getMemberid());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAllPayments() {
		return paymentDao.finAll();
	}

	@Override
	public void sentErrorMessage(String message, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", message);
	}

	@Override
	public void sentMessage(String message, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", message);
	}

	@Override
	public VALIDATE_RESULT validatePayment(Payment payment) {
		if(payment.getCardid().equals("") || payment.getQuantity() <= 0){
			return VALIDATE_RESULT.信息填写不完整;
		}
		return VALIDATE_RESULT.验证成功;
	}

}
