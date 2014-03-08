package edu.nju.healthclub.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.nju.healthclub.dao.ManagerDao;
import edu.nju.healthclub.model.Manager;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager find(String column, String value) {
		try{
			Configuration configuration = new Configuration().configure();
	    	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
	    	Session session = sessionFactory.openSession();
	    	
	    	String sql = "from edu.nju.healthclub.model.Manager as ms where ms."
	    			+ column + "='" + value + "'";
	    	
	    	Query query = session.createQuery(sql);
	    	@SuppressWarnings("rawtypes")
			List list = query.list();
	    	
	    	if((list.size()) == 0) {
	    		return null;
	    	} else {
	    		return (Manager) list.get(0);
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}

}
