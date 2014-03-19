package edu.nju.healthclub.dao.impl;

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
			System.out.println("member update" + member.getBalance());
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
			System.out.println("member" + member.getMemberid());
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

	@Override
	public List getSex() {
		try {
	         Configuration configuration = new Configuration().configure();
	         @SuppressWarnings("deprecation")
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	         Session session = sessionFactory.openSession();
	        
	         String sql = "select new edu.nju.healthclub.model.MemberSex(sex,count(*)) from edu.nju.healthclub.model.Member ms group by sex";
	        
	         Query query = session.createQuery(sql);
			List list = query.list();
			return list;
			        } catch (Exception e) {
			         e.printStackTrace();
			        }
			return null;
	}

	@Override
	public List getAge() {
		try {
        	Configuration configuration = new Configuration().configure();
        	@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = configuration.buildSessionFactory();
        	Session session = sessionFactory.openSession();
        	
        	String sql = "select nnd from"
        			+ "(select case"
        			+ " when age>=0 and age<=10 then '1-10' "
        			+ " when age>=11 and age<=20 then '11-20' "
        			+ " when age>=21 and age<=30 then '21-30' "
        			+ " when age>=31 and age<=40 then '31-40' "
        			+ " when age>=41 and age<=50 then '41-50' "
        			+ " when age>=51 and age<=60 then '51-60' "
        			+ " when age>=61 then '>60' "
        			+ " end as nnd from edu.nju.healthclub.model.Member) group by nnd";
        	
        	Query query = session.createQuery(sql);
			List list = query.list();
			return list;
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}

}
