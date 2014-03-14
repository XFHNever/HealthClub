package edu.nju.healthclub.action;


import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.RandomUtils;
import edu.nju.healthclub.service.MemberService;
import edu.nju.healthclub.service.enuminfo.MEMBER_STATE;
import edu.nju.healthclub.service.enuminfo.MEMBER_TYPE;
import edu.nju.healthclub.service.enuminfo.REGISTER_RESULT;

@SuppressWarnings("serial")
public class RegisterAction extends BaseAction{
	private Member member;
	private String memberid;
	private MemberService memberService;
	
	@Override
	public String execute() throws Exception {
		
		if(this.request().getParameter("passwordOne").equals(this.request().getParameter("passwordTwo"))){
			member.setPassword(this.request().getParameter("passwordOne"));
		}
		else{
			//memberService.sentErrorMessage((REGISTER_RESULT.两次密码不相同.toString()), this.request(),this.response());
			addActionError(REGISTER_RESULT.两次密码不相同.toString());
			return INPUT;
		}
		
		member.setBalance(0);
		
		if(member.getType() .equals(MEMBER_TYPE.个人.toString())) {
			memberid = "1";
		} else {
			memberid = "0";
		}
		String tem =  RandomUtils.getUsername(6);
		memberid += tem;
		member.setMemberid(memberid);
		
		member.setState(MEMBER_STATE.NOTACTIVE.toString());
		member.setBreaktime(0);
		
		
 		REGISTER_RESULT result = memberService.registerMember(member);
 		if(result == REGISTER_RESULT.注册成功) {
 			return "success";
 		} else {
 			//memberService.sentErrorMessage(result.toString(), this.request(), this.response());
 			addActionError(result.toString());
 			return "fail";
 		}
		
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	
}
