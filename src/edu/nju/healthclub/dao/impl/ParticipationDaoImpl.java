package edu.nju.healthclub.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.healthclub.dao.ParticipationDao;
import edu.nju.healthclub.model.Daily_Member;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Participation;

public class ParticipationDaoImpl implements ParticipationDao {

	@Override
	public Participation find(String column, String value) {
		try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Participation as ms where ms."
        			+ column + "='" + value + "'";
        	
        	Query query = session.createQuery(sql);
        	@SuppressWarnings("rawtypes")
			List list = query.list();
        	
        	if((list.size()) == 0) {
        		return null;
        	} else {
        		return (Participation) list.get(0);
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
        	
        	String sql = "from edu.nju.healthclub.model.Participation";
        	
        	Query query = session.createQuery(sql);

        	return query.list();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

	@Override
	public void save(Participation participation) {
		try {
	    	   Configuration configuration = new Configuration().configure();
	    	   
	    	   @SuppressWarnings("deprecation")
	    	   SessionFactory sessionFactory = configuration.buildSessionFactory();
	    	   Session session = sessionFactory.openSession();
	    	   Transaction transaction = session.beginTransaction();
	    	   session.save(participation);
	    	   transaction.commit();
	    	   session.close();
	    	   sessionFactory.close();
	       } catch (Exception e) {
	    	   e.printStackTrace();
	       }

	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findByKey(String column, String value) {
		try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Participation as ms where ms."
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

	@SuppressWarnings("rawtypes")
	@Override
	public List findDaily() {
		try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	
        	String sql = "select new edu.nju.healthclub.model.Daily_Member(date,count(*)) from edu.nju.healthclub.model.Participation ps group by date";
        	
        	Query query = session.createQuery(sql);
			List list = query.list();
        	
			return list;
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

}
