package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.service.ActivityService;
import edu.nju.healthclub.service.MemberService;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction{
	private MemberService memberService;
	private ActivityService activityService;
	private String memberid;
	private String password;
	private List activities;
	
	public String execute() throws Exception {
		if(memberid.equals("") || password.equals("")) {
			memberService.sentErrorMessage(VALIDATE_RESULT.信息填写不完整.toString(), this.request(), this.response());
			return "fail";
		}
		Member member = memberService.validateMember(memberid);
		
		if(member == null) {
			memberService.sentErrorMessage(VALIDATE_RESULT.账号错误.toString(), this.request(), this.response());
			return "fail";
		}
		
		if(member.getPassword().equals(password)) {
			memberService.sentMessage(VALIDATE_RESULT.验证成功.toString(), this.request(), this.response());
			activities = activityService.getAllActivities();
			
			return "member";
		} else {
			memberService.sentErrorMessage(VALIDATE_RESULT.密码错误.toString(), this.request(), this.response());
			return "fail";
		}
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public List getActivities() {
		return activities;
	}

	public void setActivities(List activities) {
		this.activities = activities;
	}

	public ActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	
}
