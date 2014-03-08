package edu.nju.healthclub.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.ParticipationDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Participation;
import edu.nju.healthclub.service.ParticipationService;

public class ParticipationServiceImpl implements ParticipationService {
	private ParticipationDao participationDao;
	@Override
	public ParticipationDao getParticipationDao() {
		return participationDao;
	}

	@Override
	public void setParticipationDao(ParticipationDao participationDao) {
		this.participationDao = participationDao;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getParticipation(Member member) {
		return participationDao.findByKey("memberid", member.getMemberid());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAllParticipation() {
		return participationDao.finAll();
	}

	@Override
	public void addNewParticipation(Participation participation) {
		participationDao.save(participation);
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
