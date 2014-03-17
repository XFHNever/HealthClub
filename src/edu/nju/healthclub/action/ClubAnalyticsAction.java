package edu.nju.healthclub.action;

import java.util.ArrayList;
import java.util.List;

import edu.nju.healthclub.model.Daily_Member;
import edu.nju.healthclub.service.ActivityService;
import edu.nju.healthclub.service.ParticipationService;

public class ClubAnalyticsAction extends BaseAction{
	public static final String FIELD[] = {"14-216","Library","Basketball court","Swimming Pool","football court","ground track field","supermarket"};
	private ParticipationService participationService;
	private ActivityService activityService;
	private List day_members;
	private String datelist;
	private String numberlist;
	
	private String fieldlist;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		day_members = participationService.getDaily();
	
		datelist = "";
		numberlist = "";
		fieldlist = "";
		
		int length = day_members.size();
		if(length < 1) {
			return "success";
		}
		for(int i = 0; i < length-1; i++) {
			datelist = datelist + "'" + ((Daily_Member)day_members.get(i)).getDate() + "',";
			numberlist += ((Daily_Member)day_members.get(i)).getCount() + ",";
		}
		numberlist = numberlist + ((Daily_Member)day_members.get(length-1)).getCount();
		datelist = datelist + "'" + ((Daily_Member)day_members.get(length-1)).getDate() + "'";

		int fieldLength = FIELD.length;
		long tem[] = new long[fieldLength];
		for(int j = 0; j < fieldLength-1; j++) {
			tem[j] = activityService.getFieldUsage(FIELD[j]);
			fieldlist = fieldlist + tem[j] + ",";
		}
		
		fieldlist += activityService.getFieldUsage(FIELD[length-1]);
		
		
		return "success";
	}
	

	public ParticipationService getParticipationService() {
		return participationService;
	}
	public void setParticipationService(ParticipationService participationService) {
		this.participationService = participationService;
	}
	public List getDay_members() {
		return day_members;
	}
	public void setDay_members(List day_members) {
		this.day_members = day_members;
	}
	public String getDatelist() {
		return datelist;
	}
	public void setDatelist(String datelist) {
		this.datelist = datelist;
	}
	public String getNumberlist() {
		return numberlist;
	}
	public void setNumberlist(String numberlist) {
		this.numberlist = numberlist;
	}


	public ActivityService getActivityService() {
		return activityService;
	}


	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}


	public String getFieldlist() {
		return fieldlist;
	}


	public void setFieldlist(String fieldlist) {
		this.fieldlist = fieldlist;
	}
	
}
