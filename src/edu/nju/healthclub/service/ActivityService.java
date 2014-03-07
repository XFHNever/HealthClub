package edu.nju.healthclub.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.ActivityDao;
import edu.nju.healthclub.model.Activity;

public interface ActivityService {
	/*
	 * set �� get ����
	 */
	public ActivityDao getActivityDao();
	public void setActivityDao(ActivityDao activityDao);
	/**
	 * �ƶ�һ���»��
	 * @param activity Activity����
	 */
	public void addNewActivity(Activity activity);
	
	/**
	 * ��ȡ���еĻ��¼��
	 * @return Activity������б�
	 */
	public List getAllActivities();
	
	/**
	 * ��ȡ�������ڽ��еĻ��
	 * @return Activity������б�
	 */
	public List getCurrentActivities();
	
	/**
	 * ���ʹ�����Ϣ
	 * @param message ��Ϣ����
	 * @param req  HttpServletRequest
	 * @param resp HttpServletResponse
	 */
	public void sentErrorMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException;

	/**
	 * ������Ϣ
	 * @param message ��Ϣ����
	 * @param req  HttpServletRequest
	 * @param resp HttpServletResponse
	 */
	public void sentMessage(String message,HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException; 
}
