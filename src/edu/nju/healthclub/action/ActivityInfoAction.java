package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Activity;
import edu.nju.healthclub.service.ActivityService;
import edu.nju.healthclub.service.SessionService;

@SuppressWarnings("serial")
public class ActivityInfoAction extends BaseAction{
	private SessionService sessionService;
	private ActivityService activityService;
	@SuppressWarnings("rawtypes")
	private List sessions;
	private Activity activity;
	
	@Override
	public String execute() throws Exception {
		
		String activityid = request().getParameter("activityid");
		String status = request().getParameter("status");
		if(activityid == null) {
			addActionError(activityid);
			return "fail";
		}
		activity = activityService.getActivityById(activityid);
		sessions = sessionService.getSessionsByActivity(activity.getId() + "");
		
		System.out.println("status:" + status);
		if(status != null) {
			return "waiter";
		} else {
			return "success";
		}
		
	}
	public SessionService getSessionService() {
		return sessionService;
	}
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}
	
	public ActivityService getActivityService() {
		return activityService;
	}
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	public List getSessions() {
		return sessions;
	}
	public void setSessions(List sessions) {
		this.sessions = sessions;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
