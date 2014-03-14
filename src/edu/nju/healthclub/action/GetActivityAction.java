package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.service.ActivityService;

@SuppressWarnings("serial")
public class GetActivityAction extends BaseAction{
	private ActivityService activityService;
	@SuppressWarnings("rawtypes")
	private List activities;
	@Override
	public String execute() throws Exception {
		activities = activityService.getAllActivities();
		Member member = (Member) this.request().getSession().getAttribute("user");
		if(member != null) {
			return "success";
		} else {
			return "fail";
		}
	}
	public ActivityService getActivityService() {
		return activityService;
	}
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	public List getActivities() {
		return activities;
	}
	public void setActivities(List activities) {
		this.activities = activities;
	}
	
}
