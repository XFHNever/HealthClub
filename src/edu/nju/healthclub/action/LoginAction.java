package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Manager;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Waiter;
import edu.nju.healthclub.service.ActivityService;
import edu.nju.healthclub.service.ManagerService;
import edu.nju.healthclub.service.MemberService;
import edu.nju.healthclub.service.ParticipationService;
import edu.nju.healthclub.service.WaiterService;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction{
	private MemberService memberService;
	private WaiterService waiterService;
	private ManagerService managerService;
	private ActivityService activityService;
	private ParticipationService participationService;
	private String memberid;
	private String password;
	@SuppressWarnings("rawtypes")
	private List activities;
	private List m_activities;
	private String state;
	
	public String execute() throws Exception {
		System.out.println("loginAction is called!!");
		if(memberid.equals(" ") || password.equals(" ")) {
			addActionError(VALIDATE_RESULT.–≈œ¢ÃÓ–¥≤ªÕÍ’˚.toString());
			return "fail";
		}
		if(memberid.startsWith("1")) {
			Member member = memberService.validateMember(memberid);
			
			if(member == null) {
				addActionError(VALIDATE_RESULT.’À∫≈¥ÌŒÛ.toString());
				return "fail";
			}
			
			if(member.getPassword().equals(password)) {
				activities = activityService.getAllActivities();
				m_activities = participationService.getParticipation(member);
				this.request().getSession().setAttribute("user", member);
				state = member.getState();
				return "member";
			} else {
				addActionError(VALIDATE_RESULT.√‹¬Î¥ÌŒÛ.toString());
				return "fail";
			}
		} else if(memberid.startsWith("8")) {
			Waiter waiter = waiterService.validateWaiter(memberid);
			
			if(waiter == null) {
				addActionError(VALIDATE_RESULT.’À∫≈¥ÌŒÛ.toString());
				return "fail";
			}
			
			if(waiter.getPassword().equals(password)) {
				//addActionMessage(VALIDATE_RESULT.—È÷§≥…π¶.toString());
				activities = activityService.getAllActivities();
				this.request().getSession().setAttribute("user", waiter);
				return "waiter";
			} else {
				addActionError(VALIDATE_RESULT.√‹¬Î¥ÌŒÛ.toString());
				return "fail";
			}
		} else if(memberid.startsWith("9")) {
			Manager manager = managerService.validateManager(memberid);
			
			if(manager == null) {
				addActionError(VALIDATE_RESULT.’À∫≈¥ÌŒÛ.toString());
				return "fail";
			}
			
			if(manager.getPassword().equals(password)) {
				activities = activityService.getAllActivities();
				this.request().getSession().setAttribute("user", manager);
				return "manager";
			} else {
				addActionError(VALIDATE_RESULT.√‹¬Î¥ÌŒÛ.toString());
				return "fail";
			}
		} else {
			Member member = memberService.validateMember(memberid);
			
			if(member == null) {
				addActionError(VALIDATE_RESULT.’À∫≈¥ÌŒÛ.toString());
				return "fail";
			}
			
			if(member.getPassword().equals(password)) {
				activities = activityService.getAllActivities();
				m_activities = participationService.getParticipation(member);
				state = member.getState();
				this.request().getSession().setAttribute("user", member);
				return "member";
			} else {
				addActionError(VALIDATE_RESULT.√‹¬Î¥ÌŒÛ.toString());
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

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public List getM_activities() {
		return m_activities;
	}

	public void setM_activities(List m_activities) {
		this.m_activities = m_activities;
	}

	public ParticipationService getParticipationService() {
		return participationService;
	}

	public void setParticipationService(ParticipationService participationService) {
		this.participationService = participationService;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
