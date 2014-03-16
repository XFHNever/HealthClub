package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.service.MemberService;
import edu.nju.healthclub.service.ParticipationService;
import edu.nju.healthclub.service.PaymentService;

public class MemberInfoAction extends BaseAction{
	private MemberService memberService;
	private ParticipationService participationService;
	private PaymentService paymentService;
	private Member member;
	private List activities;
	private List payments;
	
 	@Override
	public String execute() throws Exception {
 		String memberid = request().getParameter("memberid");
 		if(memberid == null) {
 			return INPUT;
 		}
 		
 		member = memberService.validateMember(memberid);
 		if(member == null) {
 			return INPUT;
 		}
 		
 		activities = participationService.getParticipation(member);
 		payments = paymentService.getPayments(member);
 		
		return "success";
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public ParticipationService getParticipationService() {
		return participationService;
	}
	public void setParticipationService(ParticipationService participationService) {
		this.participationService = participationService;
	}
	public PaymentService getPaymentService() {
		return paymentService;
	}
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public List getActivities() {
		return activities;
	}
	public void setActivities(List activities) {
		this.activities = activities;
	}
	public List getPayments() {
		return payments;
	}
	public void setPayments(List payments) {
		this.payments = payments;
	}
}
