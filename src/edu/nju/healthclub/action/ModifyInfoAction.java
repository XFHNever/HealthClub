package edu.nju.healthclub.action;

import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.service.MemberService;
import edu.nju.healthclub.service.enuminfo.UPDATE_RESULT;

public class ModifyInfoAction extends BaseAction{
	private MemberService memberService;
	private Member member;
	@Override
	public String execute() throws Exception {
		member = (Member) this.request().getSession().getAttribute("user");
		if(member == null) {
			return "notlogin";
		}
		
		member.setAddress(this.request().getParameter("member.address"));
		member.setAge(Integer.parseInt(this.request().getParameter("member.age")));
		member.setName(this.request().getParameter("member.name"));
		member.setSex(this.request().getParameter("member.sex"));
		member.setPassword(this.request().getParameter("member.password"));
		if(member.getType().equals("家庭")){
			member.setChildnum(Integer.parseInt(this.request().getParameter("member.childnum")));
		}
		
		UPDATE_RESULT result = memberService.updateMember(member);
		if(result == UPDATE_RESULT.更新成功) {
			this.request().getSession().setAttribute("user", member);
			return "success";
		} else {
			this.addActionError(result.toString());
			return "fail";
		}
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
