package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Payment;
import edu.nju.healthclub.service.MemberService;
import edu.nju.healthclub.service.PaymentService;
import edu.nju.healthclub.service.enuminfo.MEMBER_STATE;
import edu.nju.healthclub.service.enuminfo.PAY_RESULT;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

@SuppressWarnings("serial")
public class PayAction extends BaseAction{
	private PaymentService paymentService;
	private MemberService memberService;
	private Payment payment;
	@SuppressWarnings("rawtypes")
	private List m_payments;
	
	@Override
	public String execute() throws Exception {
		
		if(paymentService.validatePayment(payment) == VALIDATE_RESULT.信息填写不完整) {
			addActionError(VALIDATE_RESULT.信息填写不完整.toString());
			return "fail";
		}
		
		payment.setCurrentTime();
		Member member = (Member) this.request().getSession().getAttribute("user");
		if(member == null) {
			return "notlogin";
		} else {
			member.setBalance(member.getBalance() + payment.getQuantity());
			
			
			payment.setMemberid(member.getMemberid());
			paymentService.getPayments(member);
		}
		payment.setPaymentidByDate();
		
		PAY_RESULT pay_result = paymentService.addNewPayment(payment);
		
		if(pay_result == PAY_RESULT.支付成功) {
			this.request().getSession().setAttribute("user", member);
			m_payments = paymentService.getPayments(member);
			addActionMessage(pay_result.toString());
			member.setState(MEMBER_STATE.USING.toString());
			this.request().setAttribute("user", member);
			return "success";
		} else {
			addActionError(pay_result.toString());
			return "fail";
		}
		
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List getM_payments() {
		return m_payments;
	}

	public void setM_payments(List m_payments) {
		this.m_payments = m_payments;
	}

	
}
