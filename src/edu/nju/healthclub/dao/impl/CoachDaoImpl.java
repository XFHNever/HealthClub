package edu.nju.healthclub.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.nju.healthclub.dao.CoachDao;
import edu.nju.healthclub.model.Coach;

public class CoachDaoImpl implements CoachDao{

	@Override
	public Coach find(String column, String value) {
        try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Coach as cs where cs."
        			+ column + "='" + value + "'";
        	
        	Query query = session.createQuery(sql);
        	@SuppressWarnings("rawtypes")
			List list = query.list();
        	
        	if((list.size()) == 0) {
        		return null;
        	} else {
        		return (Coach) list.get(0);
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List finAll() {
        try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Coach";
        	
        	Query query = session.createQuery(sql);
        	List list = query.list();
        	
        	return list;
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

}
