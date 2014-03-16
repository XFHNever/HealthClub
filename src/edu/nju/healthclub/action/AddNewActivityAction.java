package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.Activity;
import edu.nju.healthclub.service.ActivityService;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

@SuppressWarnings("serial")
public class AddNewActivityAction extends BaseAction{
	private ActivityService activityService;
	private Activity activity;
	private String activityid;
	@Override
	public String execute() throws Exception {
		VALIDATE_RESULT validate_result = activityService.validateUpdateActivity(activity);
		if(validate_result == VALIDATE_RESULT.信息填写不完整) {
			addActionError(validate_result.toString());
			return "fail";
		}
		
		activityService.addNewActivity(activity);
		List list = activityService.getAllActivities();
		int id = ((Activity)list.get(list.size() - 1)).getId();
		activityid = id + "";
		//	request().setAttribute("activityid", id);
		return "success";
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

	public String getActivityid() {
		return activityid;
	}

	public void setActivityid(String activityid) {
		this.activityid = activityid;
	}
	
}
