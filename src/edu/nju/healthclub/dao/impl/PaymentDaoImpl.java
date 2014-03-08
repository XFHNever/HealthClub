package edu.nju.healthclub.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.healthclub.dao.PaymentDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.model.Payment;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public Payment find(String column, String value) {
		try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Payment as ms where ms."
        			+ column + "='" + value + "'";
        	
        	Query query = session.createQuery(sql);
        	@SuppressWarnings("rawtypes")
			List list = query.list();
        	
        	if((list.size()) == 0) {
        		return null;
        	} else {
        		return (Payment) list.get(0);
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
        	
        	String sql = "from edu.nju.healthclub.model.Payment";
        	
        	Query query = session.createQuery(sql);

        	return query.list();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

	@Override
	public void save(Payment payment) {
		try {
	    	   Configuration configuration = new Configuration().configure();
	    	   
	    	   @SuppressWarnings("deprecation")
	    	   SessionFactory sessionFactory = configuration.buildSessionFactory();
	    	   Session session = sessionFactory.openSession();
	    	   Transaction transaction = session.beginTransaction();
	    	   session.save(payment);
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
        	
        	String sql = "from edu.nju.healthclub.model.Payment as ms where ms."
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
