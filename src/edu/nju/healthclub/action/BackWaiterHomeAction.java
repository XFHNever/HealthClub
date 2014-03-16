package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.service.ActivityService;

public class BackWaiterHomeAction extends BaseAction{
	private ActivityService activityService;
	private List activities;
	@Override
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
	public List getActivities() {
		return activities;
	}
	public void setActivities(List activities) {
		this.activities = activities;
	}
	
	
}
