package edu.nju.healthclub.action;


import java.sql.Date;

import edu.nju.healthclub.model.Session;
import edu.nju.healthclub.service.SessionService;

@SuppressWarnings("serial")
public class AddNewSessionAction extends BaseAction{
	private SessionService sessionService;
	//private Session ses;
	private String activityid;
	@SuppressWarnings("deprecation")
	@Override
	public String execute() throws Exception {
		Session ses = new Session();
		activityid = this.request().getParameter("aid");
		if(activityid == null) {
			addActionError("没有对应的Activity");
			return "input";
		}
		String time = this.request().getParameter("time");
		String result[] = time.split("/");
		System.out.println("date" + time);
		System.out.println("result[2]:" + result[2] + "result[1]:" + result[1] + "result[0]:" + result[0]);
		Date date = new Date(Integer.parseInt(result[2])-1900, Integer.parseInt(result[0])-1, Integer.parseInt(result[1]));
		
		ses.setTime(date);
 		ses.setActivityid(activityid);
		ses.setSessionidByDate();
		
		sessionService.addNewSession(ses);
		addActionMessage("添加场次成功，请继续添加或者结束");
		return "success";
	}
	public SessionService getSessionService() {
		return sessionService;
	}
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}


	public String getActivityid() {
		return activityid;
	}
	public void setActivityid(String activityid) {
		this.activityid = activityid;
	}
	
	
}
