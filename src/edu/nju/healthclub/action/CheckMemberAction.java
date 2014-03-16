package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.service.MemberService;

public class CheckMemberAction extends BaseAction{
	private MemberService memberService;
	private List members;
	@Override
	public String execute() throws Exception {
		members = memberService.getAll();
		return "success";
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public List getMembers() {
		return members;
	}
	public void setMembers(List members) {
		this.members = members;
	}
	
	
}
