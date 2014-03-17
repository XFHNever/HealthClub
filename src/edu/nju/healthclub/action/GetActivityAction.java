package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.service.ActivityService;
import edu.nju.healthclub.service.ParticipationService;

@SuppressWarnings("serial")
public class GetActivityAction extends BaseAction{
	private ActivityService activityService;
	private ParticipationService participationService;
	@SuppressWarnings("rawtypes")
	private List activities;
	private List m_activities;
	private String state;
	@Override
	public String execute() throws Exception {
		activities = activityService.getAllActivities();
		Member member = (Member) this.request().getSession().getAttribute("user");
		if(member != null) {
			m_activities = participationService.getParticipation(member);
			state = member.getState();
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
	public ParticipationService getParticipationService() {
		return participationService;
	}
	public void setParticipationService(ParticipationService participationService) {
		this.participationService = participationService;
	}
	public List getM_activities() {
		return m_activities;
	}
	public void setM_activities(List m_activities) {
		this.m_activities = m_activities;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
