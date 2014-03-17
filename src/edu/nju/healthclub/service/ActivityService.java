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
	 * set �� get ����
	 */
	public ActivityDao getActivityDao();
	public void setActivityDao(ActivityDao activityDao);
	
	public long getFieldUsage(String field);
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
	 * ͨ��id��ѯActivity������Activity����.
	 * @param activityid id
	 * @return Activity����
	 */
	public Activity getActivityById(String activityid);
	
	/**
	 * ��֤Activity������Ϣ�Ƿ���д����,������֤��ö�ٽ����
	 * @param activity Activity����
	 * @return ��֤�����ö�ٽ��
	 */
	public VALIDATE_RESULT validateUpdateActivity(Activity activity);
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
