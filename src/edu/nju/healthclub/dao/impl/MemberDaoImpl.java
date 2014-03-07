package edu.nju.healthclub.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.nju.healthclub.dao.MemberDao;
import edu.nju.healthclub.model.Member;

public class MemberDaoImpl implements MemberDao{

	@Override
	public void save(Member member) {
       try {
    	   Configuration configuration = new Configuration().configure();
    	   
    	   @SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
    	   Session session = sessionFactory.openSession();
    	   Transaction transaction = session.beginTransaction();
    	   session.save(member);
    	   transaction.commit();
    	   session.close();
    	   sessionFactory.close();
       } catch (Exception e) {
    	   e.printStackTrace();
       }
	}

	@Override
	public Member find(String column, String value) {
        try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Member as ms where ms."
        			+ column + "='" + value + "'";
        	
        	Query query = session.createQuery(sql);
        	@SuppressWarnings("rawtypes")
			List list = query.list();
        	
        	if((list.size()) == 0) {
        		return null;
        	} else {
        		return (Member) list.get(0);
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

	@Override
	public void updateByMemberid(Member member) {
		try {
			Configuration configuration = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory =configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(member);
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}

	@Override
	public void delete(Member member) {
		try {
			Configuration configuration = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(member);
			transaction.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> findAll() {
		try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	
        	String sql = "from edu.nju.healthclub.model.Member";
        	
        	Query query = session.createQuery(sql);

        	return query.list();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

}
