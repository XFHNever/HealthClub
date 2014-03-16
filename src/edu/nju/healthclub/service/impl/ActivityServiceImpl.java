package edu.nju.healthclub.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.ActivityDao;
import edu.nju.healthclub.model.Activity;
import edu.nju.healthclub.service.ActivityService;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

public class ActivityServiceImpl implements ActivityService {
	private ActivityDao activityDao;
	@Override
	public ActivityDao getActivityDao() {
		return activityDao;
	}

	@Override
	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	@Override
	public void addNewActivity(Activity activity) {
		activityDao.save(activity);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAllActivities() {
		return activityDao.finAll();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getCurrentActivities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sentErrorMessage(String message, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", message);
	}

	@Override
	public void sentMessage(String message, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", message);
	}

	@Override
	public VALIDATE_RESULT validateUpdateActivity(Activity activity) {
		if(activity.getField().equals("") || activity.getName().equals("") || activity.getCoachid().equals("")) {
			return VALIDATE_RESULT.信息填写不完整;
		}
		return VALIDATE_RESULT.验证成功;
	}

	@Override
	public Activity getActivityById(String activityid) {
		return activityDao.find("id", activityid);
	}

}
