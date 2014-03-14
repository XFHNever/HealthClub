package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.service.PaymentService;

@SuppressWarnings("serial")
public class GetPaymentAction extends BaseAction{
	private PaymentService paymentService;
	@SuppressWarnings("rawtypes")
	private List m_payments;
	
	@Override
	public String execute() throws Exception {
		Member member = (Member) this.request().getSession().getAttribute("user");
		if(member != null) {
			m_payments = paymentService.getPayments(member);
			return "success";
		} else {
			return "fail";
		}
		
	}


	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}



	@SuppressWarnings("rawtypes")
	public List getM_payments() {
		return m_payments;
	}


	public void setM_payments(List m_payments) {
		this.m_payments = m_payments;
	}


	public List getM_activities() {
		return m_payments;
	}

	public void setM_activities(List m_activities) {
		this.m_payments = m_activities;
	}

}
