package edu.nju.healthclub.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.CoachDao;
import edu.nju.healthclub.service.CoachService;

public class CoachServiceImpl implements CoachService{
	private CoachDao coachDao;
	@Override
	public CoachDao getCoachDao() {
		return coachDao;
	}

	@Override
	public void setCoachDao(CoachDao coachDao) {
		this.coachDao = coachDao;
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



}
