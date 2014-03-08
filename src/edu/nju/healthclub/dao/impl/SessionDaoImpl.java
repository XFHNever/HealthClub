package edu.nju.healthclub.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.healthclub.dao.SessionDao;
import edu.nju.healthclub.model.Session;

public class SessionDaoImpl implements SessionDao {

	@Override
	public Session find(String column, String value) {
        try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	org.hibernate.Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Session ss ms where ss."
        			+ column + "='" + value + "'";
        	
        	Query query = session.createQuery(sql);
        	@SuppressWarnings("rawtypes")
			List list = query.list();
        	
        	if((list.size()) == 0) {
        		return null;
        	} else {
        		return (Session) list.get(0);
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
        	org.hibernate.Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Session";
        	
        	Query query = session.createQuery(sql);

        	return query.list();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

	@Override
	public void save(Session session) {
		try {
	    	   Configuration configuration = new Configuration().configure();
	    	   
	    	   @SuppressWarnings("deprecation")
	    	   SessionFactory sessionFactory = configuration.buildSessionFactory();
	    	   org.hibernate.Session hs = sessionFactory.openSession();
	    	   Transaction transaction = hs.beginTransaction();
	    	   hs.save(session);
	    	   transaction.commit();
	    	   hs.close();
	    	   sessionFactory.close();
	       } catch (Exception e) {
	    	   e.printStackTrace();
	       }

	}

	@Override
	public List findByKey(String column, String value) {
		try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	org.hibernate.Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Session ss ms where ss."
        			+ column + "='" + value + "'";
        	
        	Query query = session.createQuery(sql);
        	@SuppressWarnings("rawtypes")
			List list = query.list();
        	
        	return list;
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

}
