package edu.nju.healthclub.action;

import edu.nju.healthclub.model.Member;

@SuppressWarnings("serial")
public class GetPersonalInfoAction extends BaseAction{
	private Member member;
	@Override
	public String execute() throws Exception {
		member = (Member) this.request().getSession().getAttribute("user");
		if(member != null) {
			return "success";
		} else {
			return "fail";
		}
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
}
