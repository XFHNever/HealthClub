package edu.nju.healthclub.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.WaiterDao;
import edu.nju.healthclub.model.Waiter;
import edu.nju.healthclub.service.WaiterService;

public class WaiterServiceImpl implements WaiterService{
	private WaiterDao waiterDao;
	@Override
	public WaiterDao getWaiterDao() {
		return waiterDao;
	}

	@Override
	public void setWaiterDao(WaiterDao waiterDao) {
		this.waiterDao = waiterDao;
	}

	@Override
	public Waiter validateWaiter(String waiterid) {
		Waiter waiter = waiterDao.find("waiterid", waiterid);
		return waiter;
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
