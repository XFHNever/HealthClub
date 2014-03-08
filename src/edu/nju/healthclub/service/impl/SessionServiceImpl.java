package edu.nju.healthclub.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.ParticipationDao;
import edu.nju.healthclub.dao.SessionDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Participation;
import edu.nju.healthclub.model.Session;
import edu.nju.healthclub.service.SessionService;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

public class SessionServiceImpl implements SessionService {
	private SessionDao sessionDao;
	private ParticipationDao participationDao;
	@Override
	public SessionDao getSessionDao() {
		return sessionDao;
	}

	@Override
	public void setSessionDao(SessionDao sessionDao) {
		this.sessionDao = sessionDao;
	}

	@Override
	public ParticipationDao getParticipationDao() {
		return participationDao;
	}
	@Override
	public void setParticipationDao(ParticipationDao participationDao) {
		this.participationDao = participationDao;
	}
	
	@Override
	public void addNewSession(Session session) {
		sessionDao.save(session);
	}

	@Override
	public VALIDATE_RESULT validateSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reserveSession(Member member,Session session) {
		Participation participation = new Participation();
		participation.setSessionid(session.getSessionid());
		participation.setMemberid(member.getMemberid());
		participation.setParticipationidByAttr();
		participationDao.save(participation);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAllSessions() {
		return sessionDao.finAll();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getSessions(Member member) {
		return sessionDao.findByKey("memberid", member.getMemberid());
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
