package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Activity;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Participation;
import edu.nju.healthclub.model.Session;
import edu.nju.healthclub.service.ActivityService;
import edu.nju.healthclub.service.ParticipationService;
import edu.nju.healthclub.service.SessionService;

@SuppressWarnings("serial")
public class ReserveAction extends BaseAction{
	private ParticipationService participationService;
	private SessionService sessionService;
	private ActivityService activityService;
	private Activity activity;
	@SuppressWarnings("rawtypes")
	private List sessions;
	
	@Override
	public String execute() throws Exception {
		Participation participation = new Participation();
		
		String sessionid = this.request().getParameter("sessionid");
		Member member = (Member) this.request().getSession().getAttribute("user");
		if(member == null) {
			addActionError("不好意思,您还未登陆！");
			return "notlogin";
		}
		
		String memberid = member.getMemberid();
		
		participation.setMemberid(memberid);
		participation.setSessionid(sessionid);
		participation.setParticipationidByAttr();
		
		participationService.addNewParticipation(participation);
		
		String activityid = sessionService.getSessionById(sessionid).getActivityid();
		activity = activityService.getActivityById(activityid);
		sessions = sessionService.getSessionsByActivity(activityid);
		addActionMessage("恭喜您，预定成功！");
		return "success";
	}
	public ParticipationService getParticipationService() {
		return participationService;
	}
	public void setParticipationService(ParticipationService participationService) {
		this.participationService = participationService;
	}
	public ActivityService getActivityService() {
		return activityService;
	}
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public List getSessions() {
		return sessions;
	}
	public void setSessions(List sessions) {
		this.sessions = sessions;
	}
	public SessionService getSessionService() {
		return sessionService;
	}
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}
	
}
