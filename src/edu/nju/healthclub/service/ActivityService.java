package edu.nju.healthclub.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.ActivityDao;
import edu.nju.healthclub.model.Activity;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

public interface ActivityService {
	/*
	 * set 和 get 方法
	 */
	public ActivityDao getActivityDao();
	public void setActivityDao(ActivityDao activityDao);
	
	public long getFieldUsage(String field);
	/**
	 * 制定一个新活动。
	 * @param activity Activity对象
	 */
	public void addNewActivity(Activity activity);
	
	/**
	 * 获取所有的活动记录。
	 * @return Activity对象的列表
	 */
	public List getAllActivities();
	
	/**
	 * 获取现在仍在进行的活动。
	 * @return Activity对象的列表
	 */
	public List getCurrentActivities();
	
	/**
	 * 通过id查询Activity，返回Activity对象.
	 * @param activityid id
	 * @return Activity对象。
	 */
	public Activity getActivityById(String activityid);
	
	/**
	 * 验证Activity对象信息是否填写完整,返回验证的枚举结果。
	 * @param activity Activity对象
	 * @return 验证结果的枚举结果
	 */
	public VALIDATE_RESULT validateUpdateActivity(Activity activity);
	/**
	 * 发送错误信息
	 * @param message 信息内容
	 * @param req  HttpServletRequest
	 * @param resp HttpServletResponse
	 */
	public void sentErrorMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException;

	/**
	 * 发送信息
	 * @param message 信息内容
	 * @param req  HttpServletRequest
	 * @param resp HttpServletResponse
	 */
	public void sentMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException; 
}
