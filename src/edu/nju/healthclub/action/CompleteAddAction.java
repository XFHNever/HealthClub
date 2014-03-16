package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.service.ActivityService;

@SuppressWarnings("serial")
public class CompleteAddAction extends BaseAction{
	private ActivityService activityService;
	@SuppressWarnings("rawtypes")
	private List activities;
	public String execute() throws Exception {
		activities = activityService.getAllActivities();
		return "success";
	}
	public ActivityService getActivityService() {
		return activityService;
	}
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	@SuppressWarnings("rawtypes")
	public List getActivities() {
		return activities;
	}
	@SuppressWarnings("rawtypes")
	public void setActivities(List activities) {
		this.activities = activities;
	}
	
}
