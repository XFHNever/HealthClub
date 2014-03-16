package edu.nju.healthclub.action;

import java.util.ArrayList;
import java.util.List;

import edu.nju.healthclub.model.Daily_Member;
import edu.nju.healthclub.service.ParticipationService;

public class ClubAnalyticsAction extends BaseAction{
	private ParticipationService participationService;
	private List day_members;
	private String datelist;
	private String numberlist;
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		day_members = participationService.getDaily();
	
		datelist = "";
		numberlist = "";
		
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
		day_members.remove(length-1);

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
	
}
