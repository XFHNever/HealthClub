package edu.nju.healthclub.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.ManagerDao;
import edu.nju.healthclub.model.Manager;
import edu.nju.healthclub.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;
	@Override
	public ManagerDao getManagerDao() {
		return managerDao;
	}

	@Override
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Override
	public Manager validateManager(String managerid) {
		Manager manager = managerDao.find("managerid", managerid);
		return manager;
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
