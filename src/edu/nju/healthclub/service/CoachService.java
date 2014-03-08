package edu.nju.healthclub.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CoachService {
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
