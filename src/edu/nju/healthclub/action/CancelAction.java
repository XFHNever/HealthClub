package edu.nju.healthclub.action;

import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.service.MemberService;

public class CancelAction extends BaseAction{
	private MemberService memberService;
	
	@Override
	public String execute() throws Exception {
		String memberid = request().getParameter("memberid");
		Member member = memberService.validateMember(memberid);
		
		if(member == null) {
			return "fail";
		} else {
			memberService.cancelQualification(member);
			this.request().getSession().setAttribute("user", null);
			return "success";
		}
		
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
}
