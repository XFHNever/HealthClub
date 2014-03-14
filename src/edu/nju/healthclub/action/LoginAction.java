package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Waiter;
import edu.nju.healthclub.service.ActivityService;
import edu.nju.healthclub.service.MemberService;
import edu.nju.healthclub.service.WaiterService;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction{
	private MemberService memberService;
	private WaiterService waiterService;
	private ActivityService activityService;
	private String memberid;
	private String password;
	@SuppressWarnings("rawtypes")
	private List activities;
	
	public String execute() throws Exception {
		if(memberid.equals(" ") || password.equals(" ")) {
			//memberService.sentErrorMessage(VALIDATE_RESULT.��Ϣ��д������.toString(), this.request(), this.response());
			addActionError(VALIDATE_RESULT.��Ϣ��д������.toString());
			return "fail";
		}
		if(memberid.startsWith("1")) {
			Member member = memberService.validateMember(memberid);
			
			if(member == null) {
			//	memberService.sentErrorMessage(VALIDATE_RESULT.�˺Ŵ���.toString(), this.request(), this.response());
				addActionError(VALIDATE_RESULT.�˺Ŵ���.toString());
				return "fail";
			}
			
			if(member.getPassword().equals(password)) {
				//memberService.sentMessage(VALIDATE_RESULT.��֤�ɹ�.toString(), this.request(), this.response());
				//addActionMessage(VALIDATE_RESULT.��֤�ɹ�.toString());
				activities = activityService.getAllActivities();
				this.request().getSession().setAttribute("user", member);
				return "member";
			} else {
				//memberService.sentErrorMessage(VALIDATE_RESULT.�������.toString(), this.request(), this.response());
				addActionError(VALIDATE_RESULT.�������.toString());
				return "fail";
			}
		} else if(memberid.startsWith("8")) {
			Waiter waiter = waiterService.validateWaiter(memberid);
			
			if(waiter == null) {
				addActionError(VALIDATE_RESULT.�˺Ŵ���.toString());
				return "fail";
			}
			
			if(waiter.getPassword().equals(password)) {
				//addActionMessage(VALIDATE_RESULT.��֤�ɹ�.toString());
				activities = activityService.getAllActivities();
				this.request().getSession().setAttribute("user", waiter);
				return "waiter";
			} else {
				addActionError(VALIDATE_RESULT.�������.toString());
				return "fail";
			}
		} else {
			Member member = memberService.validateMember(memberid);
			
			if(member == null) {
			//	memberService.sentErrorMessage(VALIDATE_RESULT.�˺Ŵ���.toString(), this.request(), this.response());
				addActionError(VALIDATE_RESULT.�˺Ŵ���.toString());
				return "fail";
			}
			
			if(member.getPassword().equals(password)) {
				//memberService.sentMessage(VALIDATE_RESULT.��֤�ɹ�.toString(), this.request(), this.response());
				//addActionMessage(VALIDATE_RESULT.��֤�ɹ�.toString());
				activities = activityService.getAllActivities();
				this.request().getSession().setAttribute("user", member);
				return "member";
			} else {
				//memberService.sentErrorMessage(VALIDATE_RESULT.�������.toString(), this.request(), this.response());
				addActionError(VALIDATE_RESULT.�������.toString());
				return "fail";
			}
		}
		
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
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
