package edu.nju.healthclub.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.healthclub.dao.ActivityDao;
import edu.nju.healthclub.model.Activity;
import edu.nju.healthclub.model.Member;

public class ActivityDaoImpl implements ActivityDao {

	@Override
	public Activity find(String column, String value) {
		try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Activity as ms where ms."
        			+ column + "='" + value + "'";
        	
        	Query query = session.createQuery(sql);
        	@SuppressWarnings("rawtypes")
			List list = query.list();
        	
        	if((list.size()) == 0) {
        		return null;
        	} else {
        		return (Activity) list.get(0);
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
        	
        	String sql = "from edu.nju.healthclub.model.Activity";
        	
        	Query query = session.createQuery(sql);

        	return query.list();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

	@Override
	public void save(Activity activity) {
		try {
	    	   Configuration configuration = new Configuration().configure();
	    	   
	    	   @SuppressWarnings("deprecation")
	    	   SessionFactory sessionFactory = configuration.buildSessionFactory();
	    	   Session session = sessionFactory.openSession();
	    	   Transaction transaction = session.beginTransaction();
	    	   session.save(activity);
	    	   transaction.commit();
	    	   session.close();
	    	   sessionFactory.close();
	       } catch (Exception e) {
	    	   e.printStackTrace();
	       }
	}

}
